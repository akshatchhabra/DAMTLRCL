#!/usr/bin/env bash

# Copyright (c) 2020 International Business Machines Corporation
# Prepared by: Geert Janssen <geert@us.ibm.com>

# The abolute directory path where this script resides:
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SCRIPT_NAME="$(basename "${BASH_SOURCE[0]}")"

die() {
    echo "(E) ${@}" 1>&2
    exit 1
}

warn() {
    echo "(W) ${@}" 1>&2
}

info() {
    # Be quiet when unset or not "":
    [ -n ${QUIET:-""} ] || echo "(I) ${@}" 1>&2
}

CONFIG="./project_codenet.conf"			 # -c option
# Directory that is the root all data and metadata:
DATA_DIR="/work/pi_adrozdov_umass_edu/transLRPL/Project_CodeNet" # -d option
DRYRUN=					 # -n option
# Root of output data tree:
OUTPUT_DIR="/work/pi_adrozdov_umass_edu/transLRPL/dataset1"      # -o option
QUIET=					 # -q option
SUPPRESS=				 # not used
NUM_SAMPLES=				 # -s option
NUM_OVERALL_SAMPLES=			 # -t option

for i in "$@"
do
case $i in
    -h|--help)
    echo "Usage: ${SCRIPT_NAME} [-hq] [-c=conf] [-d=dir] [-o=dir]"
    echo -e "  -c|--config:\tpath to the configuration file"
    echo -e "  -d|--data:\tpath to the root of the dataset directory"
    echo -e "  -h|--help:\tshow this brief usage summary"
    echo -e "  -n|--dryrun:\tdo not call the ACTION; see config"
    echo -e "  -o|--output:\tpath to the output data directory"
    echo -e "  -q|--quiet:\tsuppress informational messages"
    echo -e "  -s|--samples:\tnumber of samples per problem"
    echo -e "  -t|--total:\tgrand total number of samples"
    echo
    echo "Option defaults are (empty means not in effect):"
    echo -e "  -c:\t${CONFIG}"
    echo -e "  -d:\t${DATA_DIR}"
    echo -e "  -n:\t${DRYRUN}"
    echo -e "  -o:\t${OUTPUT_DIR}"
    echo -e "  -q:\t${QUIET}"
    echo -e "  -s:\t${NUM_SAMPLES:-all available}"
    echo -e "  -t:\t${NUM_OVERALL_SAMPLES:-all available}"
    echo
    echo "Given lists of problems, languages, statuses, minimum and maximum"
    echo "code sizes, will create the necessary directory structure"
    echo "and populate it with symbolic links from CodeNet data."
    echo "Options allow to restict the number of samples, both per problem"
    echo "as well as an overall amount."
    echo "See also: codenet_submissions.sh."
    exit 2
    ;;
    -c=*|--config=*)
    CONFIG="${i#*=}"
    shift
    ;;
    -d=*|--data=*)
    DATA_DIR="${i#*=}"
    shift
    ;;
    -n|--dryrun)
    DRYRUN=1
    shift
    ;;
    -o=*|--output=*)
    OUTPUT_DIR="${i#*=}"
    shift
    ;;
    -q|--quiet)
    QUIET=1
    shift
    ;;
    -s=*|--samples=*)
    NUM_SAMPLES="${i#*=}"
    shift
    ;;
    -t=*|--total=*)
    NUM_OVERALL_SAMPLES="${i#*=}"
    shift
    ;;
    *)
    break;
    ;;
esac
done
if [[ -n ${1:-""} ]]; then
    warn "Trailing non-option arguments are ignored"
fi

# Make sure CONFIG is present:
[ -f "${CONFIG}" ] || die "Missing configuration file: ${CONFIG}"

# The actual command to run on a solution a user option,
# this is just a default.
function ACTION() {
    # Check for presence:
    if [ -f "$1" ]; then
    cp $1 .
    # info "Copied submission $1"
    else
	warn "Submission is absent: $1"
    fi
}

# Source the configuration:
# (Searches PATH then looks in cwd)
. "${CONFIG}"
# Config defines:
# SELECT_PROBLEM(), LANGUAGES, STATUSES, MIN_CODE_SIZE, MAX_CODE_SIZE,
# NUM_SAMPLES, NUM_OVERALL_SAMPLES, ACTION()

# Dryrun mode merely echoes the submission file name.
[ "${DRYRUN}" ] && function ACTION() { echo $1; }

# Check for existence of problem directory:
[ -d "${DATA_DIR}" ] || die "Expect data directory ${DATA_DIR}"

info "Script '${SCRIPT_NAME}' parameters:"
#info "Script directory: ${SCRIPT_DIR}"
info "Configuration   : ${CONFIG}"
info "Data directory  : ${DATA_DIR}"
info "Output directory: ${OUTPUT_DIR}"
[ "${DRYRUN}" ] && yesorno="yes" || yesorno="no"
info "Dry run?        : ${yesorno}"
info "Samples amount  : ${NUM_SAMPLES:-"all available"}"
info "Overall amount  : ${NUM_OVERALL_SAMPLES:-"all available"}"

# Pass some args down to the codenet_submissions script:
SUBMISSION_ARGS=
[ -z ${QUIET} ]       || SUBMISSION_ARGS+=" -q"
[ -z ${SUPPRESS} ]    || SUBMISSION_ARGS+=" -s"
[ -z ${NUM_SAMPLES} ] || SUBMISSION_ARGS+=" -n=${NUM_SAMPLES}"
[ -z ${DATA_DIR} ]    || SUBMISSION_ARGS+=" -d=${DATA_DIR}"

# Get filenames for all selected problems, languages, and statuses and
# call ACTION on each:

[ "${DRYRUN}" ] || { mkdir -p "${OUTPUT_DIR}"; \
    pushd "${OUTPUT_DIR}" >/dev/null; }

# Assume problem_id follows the pattern p[0-9]{5}.

# OR: Enumerate all problem p?????.csv in metadata directory:

problem_num=0
# Start with smallest problem directory:
problem="p00000"
PROBLEM_DIR="${DATA_DIR}/data/${problem}"
while [ ! -d "${PROBLEM_DIR}" ]; do
    # Consider next problem:
    ((problem_num++))
    # Extend with leading 0's till length is 5:
    printf -v problem "p%05d" "${problem_num}"
    PROBLEM_DIR="${DATA_DIR}/data/${problem}"
done

# Enumerate all problems till first non-existing directory:
OVERALL_SAMPLES=0
# Cannot use break <num>; need cleanly exit each loop.
ENOUGH=

# Problem LIST CSV metadata file:
PROBLEMS_LIST_CSV="${DATA_DIR}/metadata/problem_list.csv"

# Check for existence:
[ -f "${PROBLEMS_LIST_CSV}" ] || die "Expect to read ${PROBLEMS_LIST_CSV}"

# Extract all problems from the CSV metadata:
info "Processing ${SUBMISSIONS_CSV}"
{
    read -r header
    index=0
    while IFS=, read -a line; do
    problems_list[index]="${line[0]}"
    index=$((index+1))
    done
} < "${PROBLEMS_LIST_CSV}"
echo "Problems list: ${problems_list[*]}"
for problem in "${problems_list[@]}"
do
    # Select on problem id:
    if SELECT_PROBLEM "${problem}"; then
	# Note: cwd is OUTPUT_DIR
	[ "${DRYRUN}" ] || { mkdir -p "${problem}"; \
	    pushd "${problem}" >/dev/null; }
	for lang in "${LANGUAGES[@]}"; do
	    [ "${DRYRUN}" ] || { mkdir -p "${lang}"; \
		pushd "${lang}" >/dev/null; }
	    for status in "${STATUSES[@]}"; do
		[ "${NUM_OVERALL_SAMPLES}" ] && \
  		[ "${OVERALL_SAMPLES}" -ge "${NUM_OVERALL_SAMPLES}" ] &&\
		{ ENOUGH=1; break; }

		# Tricky: must avoid subshell! So no pipe |
		while read -r line; do
		    # Could add $OVERALL_SAMPLES as arg.
		    ACTION "${line}" "${problem}" "${lang}" "${status}"
		    ((OVERALL_SAMPLES++))
		    [ "${NUM_OVERALL_SAMPLES}" ] && \
  		    [ "${OVERALL_SAMPLES}" -ge "${NUM_OVERALL_SAMPLES}" ] &&\
		    { ENOUGH=1; break; }
		done < <(${SCRIPT_DIR}/project_codenet_submissions.sh \
				      ${SUBMISSION_ARGS} \
				      "${problem}" "${lang}" "${status}" \
				      "${MIN_CODE_SIZE}" "${MAX_CODE_SIZE}")
	    done
	    [ "${DRYRUN}" ] || popd >/dev/null
	    if [ $ENOUGH ]; then break; fi
	done
	[ "${DRYRUN}" ] || popd >/dev/null
    fi
    if [ $ENOUGH ]; then break; fi

    # Consider next problem:
    ((problem_num++))
    # Extend with leading 0's till length is 5:
    printf -v problem "p%05d" "${problem_num}"
    PROBLEM_DIR="${DATA_DIR}/data/${problem}"
done
[ "${DRYRUN}" ] || popd >/dev/null

[ "${NUM_OVERALL_SAMPLES}" ] && \
[ "${OVERALL_SAMPLES}" -lt "${NUM_OVERALL_SAMPLES}" ] && \
    warn "Only found ${OVERALL_SAMPLES} samples out of the requested ${NUM_OVERALL_SAMPLES}"
