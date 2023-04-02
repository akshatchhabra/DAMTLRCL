// Copyright (c) 2019-present, Facebook, Inc.
// All rights reserved.
//
// This source code is licensed under the license found in the
// LICENSE file in the root directory of this source tree.
//

import java.util. *;
import java.util.stream.*;
import java.lang.*;
import javafx.util.Pair;
public class REMOVE_ARRAY_END_ELEMENT_MAXIMIZE_SUM_PRODUCT{
static int f_gold ( int dp [ ] [ ] , int a [ ] , int low , int high , int turn ) {
  if ( low == high ) {
    return a [ low ] * turn ;
  }
  if ( dp [ low ] [ high ] != 0 ) {
    return dp [ low ] [ high ] ;
  }
  dp [ low ] [ high ] = Math . max ( a [ low ] * turn + f_gold ( dp , a , low + 1 , high , turn + 1 ) , a [ high ] * turn + f_gold ( dp , a , low , high - 1 , turn + 1 ) ) ;
  return dp [ low ] [ high ] ;
}


//TOFILL

public static void main(String args[]) {
    int n_success = 0;
    List<int [ ] [ ]> param0 = new ArrayList<>();
    param0.add(new int[][]{new int[]{23,37,54,57,59,75,97},new int[]{9,15,34,39,80,96,99},new int[]{15,25,26,31,43,47,93},new int[]{22,31,37,44,54,62,91},new int[]{7,19,32,56,57,70,81},new int[]{16,37,49,77,81,82,85},new int[]{44,48,64,74,79,89,99}});
    param0.add(new int[][]{new int[]{-24,-34,-86,-16,-34,14,76,4,18,60,-4,-24,46,-26,-74,6,50,-34,8,-30,-62,56,-78,-50,76,-98,-64,-72,-76,46,-70,4,-92,-18,10,-76,78,-26},new int[]{-34,-30,-96,-4,76,48,-10,96,-88,96,90,40,-24,68,-42,-48,-30,-32,-44,-50,-98,34,-78,-52,-88,-38,54,-64,-94,-48,-80,-2,-90,-14,-8,90,-78,-36},new int[]{30,-80,-58,48,-80,-78,40,-48,-40,-84,2,44,72,6,78,-84,-30,-70,32,86,16,68,40,-36,80,-46,66,-92,8,72,-56,58,-72,44,40,6,66,-66},new int[]{16,-72,-66,-30,66,-94,36,-34,-78,14,-74,-54,48,6,-40,-40,-24,-6,18,-20,-88,-8,82,-56,-96,-32,30,-22,70,-4,98,-40,-72,66,-54,-60,52,66},new int[]{-28,-52,90,-52,12,98,42,-52,38,-60,-28,94,86,-22,-62,68,12,92,-82,18,-2,82,-28,72,-78,-70,40,-54,-24,-68,-74,-40,-32,14,88,94,-46,-14},new int[]{-38,-30,62,-52,54,56,12,32,-78,24,38,-82,6,-64,-96,-56,-30,62,-94,-26,-64,-38,96,72,54,-56,56,82,6,-30,94,80,-68,18,84,58,-48,-34},new int[]{82,-44,14,-26,-14,-92,62,-48,-52,26,-30,-76,-26,28,54,-16,-60,16,-76,-90,20,-8,56,-86,66,-84,92,-52,90,30,38,-2,90,-50,88,44,-66,-80},new int[]{-22,68,62,-84,-76,-12,82,70,-58,86,20,-66,96,-28,6,60,-90,52,-28,8,34,90,38,24,76,-22,6,16,-46,-4,84,-6,6,30,50,26,8,-8},new int[]{34,-62,-26,18,-14,42,-50,72,16,-62,-76,32,-20,82,8,74,60,-60,-16,-50,-38,-88,68,-26,66,-14,64,42,98,40,-56,28,-96,36,-82,-74,38,-26},new int[]{-66,-58,-84,16,-42,4,-38,-6,-32,-98,20,-96,60,-38,24,-8,-74,52,98,52,-10,-24,-22,78,-20,58,-24,-98,-76,0,-94,6,28,42,20,-36,68,-68},new int[]{-20,70,-80,68,-26,-26,-22,88,86,12,-98,-80,2,-22,-2,2,-52,-50,30,12,74,34,-14,-54,70,16,-76,-56,16,-50,-14,-4,30,48,-14,84,-34,30},new int[]{68,68,-86,66,-64,60,-28,52,14,-40,-98,22,-30,28,-48,-76,66,94,-28,32,88,86,-76,-4,68,-56,76,-4,36,16,-4,8,-44,-84,74,74,96,-22},new int[]{-14,-88,-52,-72,-60,-50,32,86,14,-26,36,-84,38,80,-86,-64,14,-96,86,-52,-48,-16,-78,-66,-10,-24,70,22,90,46,-74,36,-74,2,96,6,4,34},new int[]{-34,72,-40,34,-30,18,54,-50,0,94,-62,80,4,84,10,98,56,-36,-94,88,10,-30,90,-52,14,-46,30,82,-66,8,-98,86,-90,46,-44,-92,22,58},new int[]{70,-44,-28,-78,-62,-78,-96,-6,-92,-86,-82,72,-50,26,-4,82,-42,58,28,-88,98,-98,-14,72,-24,58,72,-72,6,-78,34,-34,58,-62,78,-98,0,50},new int[]{84,48,-82,-32,-22,16,-34,-28,-76,40,26,30,70,28,-64,-90,70,-90,82,60,10,-52,0,50,-38,-32,-18,2,48,20,-96,4,62,-28,28,-12,50,-90},new int[]{64,58,-34,10,-44,-72,62,70,60,84,-12,-46,-82,-12,80,46,44,-58,-18,10,44,50,-60,-20,82,-10,18,-4,48,22,-14,12,-76,-32,8,-60,-54,-6},new int[]{22,-58,58,-24,-58,-64,62,-38,-36,44,-82,46,-78,54,96,24,84,90,-2,-98,-74,8,44,-94,84,48,-2,66,-44,52,-42,-36,34,-98,-6,54,26,18},new int[]{-28,30,-66,-14,-20,-44,-62,-20,90,-92,-38,64,44,-60,90,-60,-82,36,-46,52,-60,26,12,80,-64,92,-22,-68,-10,54,-96,44,70,10,4,-4,-94,66},new int[]{-70,54,-32,92,-26,-66,28,-98,-14,-20,40,-36,-6,-60,-36,-32,26,90,34,-34,82,48,-82,-8,-86,-74,-58,-68,-68,-16,-26,-88,-6,-76,-12,-68,-98,-94},new int[]{14,-84,90,88,80,-28,-46,4,-4,36,-56,-44,68,24,24,70,36,-4,58,-78,14,-48,-46,58,-44,-66,72,-36,84,70,-26,72,76,30,-30,92,4,-40},new int[]{-24,-28,0,-44,-48,74,76,50,-88,36,-24,62,-34,82,-20,38,-76,16,-70,92,-82,56,72,78,40,52,-52,-38,36,-44,92,46,-60,-54,58,96,74,-18},new int[]{70,-30,-62,-74,-88,-92,72,-42,34,76,-4,-94,22,-82,56,2,44,-64,-88,-20,96,0,-12,-20,-40,-56,-8,18,-8,18,98,28,50,-14,72,50,4,38},new int[]{72,-66,16,-44,94,10,60,96,24,12,92,30,2,64,4,58,74,-24,-96,-52,72,10,-2,-18,-74,-2,70,-6,-60,72,-32,34,-78,-10,-2,-30,54,42},new int[]{80,92,18,54,-42,50,-62,76,94,38,84,78,44,98,78,-54,-36,-80,62,14,24,86,52,4,78,96,20,58,-64,-42,20,-98,-90,6,30,56,-66,-34},new int[]{-86,60,-62,-32,-12,92,-54,-2,8,58,68,42,-46,-8,82,-28,-96,62,46,-12,0,88,82,-26,-42,36,46,-46,54,-58,-58,-62,32,-48,-60,86,4,56},new int[]{88,-36,4,60,24,6,72,58,44,14,-40,-64,36,-92,36,-56,-78,86,80,80,-94,64,-4,-2,86,26,-98,-56,62,-56,-18,40,12,26,50,72,-16,-58},new int[]{-88,4,-66,64,42,94,54,-38,8,-18,-8,88,46,42,64,-88,94,58,-50,26,38,92,-66,82,8,38,-92,-32,50,-44,-88,-6,34,12,66,54,-52,-86},new int[]{20,-90,2,-94,-76,-28,-76,44,-12,-56,50,4,34,-88,46,2,60,52,22,98,-84,6,-26,-90,-4,48,-66,-42,58,-22,30,-22,-82,-50,42,84,94,4},new int[]{-56,4,-4,54,64,82,88,8,50,66,-2,80,-4,12,24,-56,-52,80,66,82,-66,-92,-42,-56,66,-92,-60,-92,-52,-54,32,22,-42,-46,-66,60,10,-62},new int[]{-44,0,6,-54,-98,72,-98,-28,-4,-86,-10,-76,-64,-66,58,60,24,90,-6,-54,-22,84,-34,64,36,18,14,-32,-88,-32,84,-8,60,98,28,-6,14,-88},new int[]{-94,-92,74,96,28,34,56,74,-62,-46,-8,10,-96,-72,50,-98,-28,72,2,46,68,14,-72,-78,-76,68,52,-30,-32,90,40,50,50,20,98,2,72,44},new int[]{-6,94,16,-70,-74,-46,22,24,44,-40,52,-50,94,-66,84,-66,14,-12,48,-6,64,-12,-44,-14,2,-48,-22,52,-28,-18,8,72,-28,68,44,-28,-20,62},new int[]{12,-94,-86,-52,-92,-76,-78,10,-8,30,34,26,-80,-8,68,92,66,16,-48,70,30,-56,-80,-78,58,94,-56,-12,56,-94,-60,-70,0,-94,6,36,48,-98},new int[]{74,72,20,-84,96,-84,40,-36,-88,-14,60,-70,36,-28,-18,-82,-36,92,-86,44,-16,-66,28,-88,-18,-52,66,-26,-90,-12,-16,80,-28,82,-92,82,-76,-80},new int[]{40,-38,-48,72,-30,70,-14,14,90,42,-6,52,-94,44,-32,-8,-74,80,-18,-10,74,-80,86,-82,-2,10,-12,58,-70,-18,86,40,62,76,88,68,68,4},new int[]{86,4,16,86,-66,72,-38,-40,-52,14,-60,-88,-44,-60,-64,84,-50,-78,-44,-18,78,74,-66,-64,18,26,74,98,-18,-96,-82,4,-74,-40,-50,-46,-4,94},new int[]{-70,-64,-10,-22,-88,-48,84,78,16,64,78,-48,66,-88,44,60,-10,-48,60,-40,86,-40,32,16,28,-30,32,-74,10,-34,38,-36,-30,2,14,-92,-48,88}});
    param0.add(new int[][]{new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}});
    param0.add(new int[][]{new int[]{84,65,61,9,50,58,19,98,63,92,42,82,5,55,81,77,1,92,74,40,13,59,48,51,18,42,34,78,41,82,13,6,92},new int[]{31,76,5,83,74,92,29,9,40,28,36,36,4,73,32,6,79,8,45,89,60,34,82,27,68,24,68,47,27,42,3,61,19},new int[]{56,19,38,73,69,25,38,90,20,50,27,8,1,84,9,44,54,64,8,74,19,52,40,9,75,66,58,8,40,46,55,54,75},new int[]{12,13,58,11,23,52,60,91,95,86,63,25,62,93,35,36,60,87,94,46,3,85,35,77,28,22,33,7,92,76,33,53,30},new int[]{2,4,55,27,47,76,45,70,34,36,5,2,50,24,32,85,81,34,5,35,56,72,21,39,58,90,49,75,74,49,76,22,30},new int[]{35,66,31,4,44,70,53,57,36,36,54,26,96,4,22,34,1,87,57,51,16,36,47,91,39,5,25,45,61,5,37,51,88},new int[]{45,98,42,35,56,86,16,75,9,32,14,92,40,25,24,29,5,1,75,13,3,8,71,79,96,33,22,13,30,20,41,84,59},new int[]{74,33,15,13,27,6,87,95,74,82,7,52,29,66,44,89,74,21,57,22,32,13,14,42,12,99,55,9,16,94,37,72,29},new int[]{64,47,16,76,77,39,94,53,65,65,80,12,25,14,6,77,66,12,37,63,78,17,32,16,22,7,40,25,8,27,32,55,39},new int[]{27,52,60,70,10,52,14,60,35,31,27,50,74,87,32,28,55,98,68,9,72,48,53,39,29,64,84,64,47,7,69,22,72},new int[]{89,58,93,44,1,12,98,64,65,97,36,4,84,47,49,77,81,11,30,3,69,73,30,68,73,10,96,40,71,57,3,81,46},new int[]{39,71,95,88,22,67,25,57,53,22,98,68,19,28,10,26,79,13,50,2,10,54,44,88,69,97,75,31,18,77,17,22,53},new int[]{85,17,87,79,24,25,49,13,15,16,36,98,41,78,77,89,31,91,20,85,51,29,55,94,69,16,85,91,83,9,66,96,16},new int[]{67,72,45,87,18,95,50,29,69,80,43,78,53,37,71,67,41,16,66,77,69,74,50,11,37,80,5,60,5,56,85,9,92},new int[]{92,36,57,21,48,29,77,51,52,74,68,1,18,60,70,47,98,75,81,17,12,74,1,52,50,21,30,24,17,56,29,65,18},new int[]{63,47,21,28,54,39,53,42,30,59,74,9,14,66,94,45,27,44,43,98,60,57,1,65,35,19,35,58,27,38,82,96,96},new int[]{29,64,7,9,34,80,65,45,40,56,95,7,32,36,9,70,83,73,92,73,20,19,65,27,87,2,88,64,48,71,20,57,11},new int[]{85,39,35,38,44,69,64,28,47,77,38,4,84,50,54,72,62,33,31,60,68,37,80,62,74,96,81,17,64,11,91,85,64},new int[]{45,96,40,46,4,53,91,75,80,53,8,29,93,10,11,48,15,96,80,13,47,23,81,23,41,59,28,37,6,16,46,49,89},new int[]{1,59,53,1,36,70,18,90,6,18,15,1,74,7,57,87,54,92,8,41,47,60,60,18,77,5,79,47,83,23,9,42,55},new int[]{45,22,54,33,86,86,2,52,34,74,17,40,78,5,77,8,52,13,8,24,27,97,9,8,28,91,74,98,99,8,18,12,85},new int[]{43,68,81,7,74,86,13,75,46,95,62,39,98,22,51,53,46,62,25,90,54,5,26,45,31,84,95,63,11,27,2,43,7},new int[]{20,68,7,65,20,49,16,59,39,68,20,43,2,37,39,14,90,45,94,31,68,94,88,72,80,95,1,88,19,93,21,71,27},new int[]{41,67,5,99,99,88,90,4,31,54,22,28,1,27,2,46,94,37,21,43,21,4,44,74,72,49,39,58,91,76,39,70,43},new int[]{23,23,33,86,60,69,14,39,49,89,1,32,65,67,62,63,16,70,59,20,53,50,8,93,52,75,77,20,16,13,92,16,18},new int[]{97,3,56,96,41,64,6,95,92,95,30,15,1,13,55,68,88,8,99,55,81,9,87,46,93,83,54,51,32,52,62,54,41},new int[]{81,13,63,13,67,97,51,72,40,49,87,12,24,92,46,46,45,38,95,67,51,51,88,62,71,66,32,57,23,27,21,13,52},new int[]{6,91,35,9,74,55,71,71,28,63,89,65,95,45,26,47,64,27,88,10,42,45,14,27,32,93,95,64,14,88,53,30,41},new int[]{55,51,89,7,37,36,89,43,26,78,33,2,21,94,58,40,95,46,68,89,38,75,97,58,78,12,6,57,18,3,96,61,17},new int[]{56,24,53,35,66,26,30,60,27,57,82,78,84,84,94,31,48,59,33,27,54,33,20,67,46,19,71,91,70,29,26,17,66},new int[]{85,48,88,33,78,98,69,3,81,70,80,66,84,61,48,17,8,25,8,29,82,59,62,1,58,71,74,86,8,94,15,22,79},new int[]{43,32,57,81,97,19,68,26,21,12,12,44,10,81,42,92,44,58,10,11,2,5,33,1,86,46,85,40,13,16,44,70,42},new int[]{31,28,33,90,54,30,46,18,1,95,73,79,87,16,87,39,92,26,85,75,42,56,11,78,50,6,63,77,46,77,45,35,83}});
    param0.add(new int[][]{new int[]{-82,-82,-76,-74,-72,-70,-70,-68,-66,-56,-56,-50,-48,-44,-42,-38,-36,-32,-26,-20,-20,-18,-8,6,8,12,12,14,18,20,24,24,30,32,36,38,40,44,50,56,60,62,66,70,76,78,90,98,98},new int[]{-92,-80,-76,-70,-58,-58,-50,-48,-38,-36,-34,-32,-30,-30,-24,-20,-20,-18,-10,-10,-8,-6,-6,-6,-4,2,10,14,24,26,30,34,36,44,52,54,64,76,78,82,86,86,86,86,86,88,88,92,94},new int[]{-98,-94,-86,-82,-80,-76,-74,-74,-72,-70,-70,-68,-66,-62,-50,-50,-48,-42,-34,-24,-22,-22,2,8,8,10,12,22,22,26,26,26,30,38,44,54,56,58,68,68,72,78,80,80,84,88,92,94,98},new int[]{-92,-88,-84,-84,-82,-78,-78,-66,-60,-48,-48,-46,-42,-40,-40,-38,-36,-34,-30,-30,-26,-26,-22,-22,-20,-14,-12,6,28,36,38,44,46,46,48,50,52,52,56,58,60,70,80,80,80,86,92,96,98},new int[]{-98,-94,-80,-76,-72,-70,-70,-70,-68,-64,-64,-62,-60,-56,-54,-52,-50,-48,-46,-42,-40,-30,-28,-28,-24,-22,-6,-4,0,2,10,12,18,18,32,36,58,60,68,70,72,74,80,84,86,88,88,94,98},new int[]{-96,-96,-86,-84,-84,-72,-72,-70,-70,-66,-64,-60,-58,-58,-46,-38,-38,-28,-22,-18,-14,16,18,20,20,24,24,26,32,32,34,40,42,42,44,44,46,56,58,60,62,64,66,68,68,68,74,78,86},new int[]{-98,-92,-70,-58,-54,-50,-50,-50,-46,-40,-40,-36,-34,-24,-22,-22,-18,-8,-6,-6,-2,2,2,10,16,16,20,22,24,26,28,28,30,32,38,40,42,48,56,56,58,60,66,66,72,84,90,94,96},new int[]{-98,-90,-82,-80,-78,-78,-70,-66,-60,-54,-48,-48,-38,-28,-18,-16,-14,-12,-12,-10,-8,-4,-4,-4,-2,0,2,6,6,12,16,18,20,24,36,46,52,54,60,62,66,66,70,70,82,82,86,86,88},new int[]{-98,-90,-88,-86,-78,-76,-76,-70,-66,-60,-56,-56,-56,-54,-52,-46,-40,-28,-26,-22,-20,-20,-18,-14,-12,-8,0,18,18,28,34,36,36,36,38,46,50,54,56,56,60,66,70,72,74,74,80,80,82},new int[]{-98,-92,-90,-86,-84,-82,-78,-70,-66,-60,-58,-44,-42,-34,-32,-30,-24,-20,-16,-8,-4,8,8,14,14,14,14,20,20,32,38,42,52,62,62,66,68,70,72,72,78,78,78,78,84,96,98,98,98},new int[]{-90,-88,-82,-82,-82,-80,-74,-68,-68,-64,-58,-56,-54,-50,-42,-36,-32,-28,-20,-20,-20,-18,-16,-14,-6,-6,-2,6,8,10,20,24,26,32,38,44,46,48,56,56,58,60,64,68,74,80,88,92,96},new int[]{-96,-94,-88,-72,-72,-72,-70,-70,-64,-52,-46,-46,-44,-38,-34,-34,-28,-26,-20,-16,-14,-10,-8,-2,-2,2,6,8,10,30,34,34,36,44,52,58,60,70,72,72,74,76,76,80,90,92,92,94,98},new int[]{-98,-98,-96,-96,-84,-82,-80,-76,-62,-52,-46,-44,-44,-40,-38,-38,-36,-30,-22,-8,-4,-2,0,2,4,8,12,20,22,26,26,30,34,46,46,52,54,56,58,60,62,66,72,74,78,80,90,92,96},new int[]{-94,-94,-92,-92,-80,-80,-74,-64,-56,-54,-52,-50,-50,-42,-42,-42,-40,-36,-36,-32,-24,-16,-14,-4,0,2,4,10,12,16,22,24,26,28,28,30,40,46,48,56,58,62,62,62,80,88,88,96,98},new int[]{-96,-94,-94,-92,-84,-82,-80,-74,-70,-58,-54,-52,-52,-48,-44,-34,-34,-30,-28,-24,-14,-12,-4,-2,2,2,4,10,12,14,24,28,38,40,46,58,62,68,72,72,74,76,82,84,84,84,84,90,98},new int[]{-98,-90,-84,-82,-76,-70,-66,-62,-60,-60,-58,-56,-54,-54,-50,-50,-46,-40,-40,-38,-32,-24,-22,-22,-20,-12,-12,-8,6,6,8,8,8,22,26,40,42,50,50,50,50,56,64,86,92,92,94,94,96},new int[]{-92,-78,-74,-68,-66,-62,-62,-62,-60,-60,-54,-40,-36,-34,-34,-32,-22,-22,-18,-14,-12,-10,-6,-4,-2,0,12,14,18,28,32,32,38,44,48,50,52,52,60,64,66,66,82,86,90,90,94,94,96},new int[]{-96,-94,-92,-90,-88,-86,-84,-76,-74,-72,-72,-68,-66,-66,-58,-52,-50,-46,-42,-34,-32,-32,-30,-14,-10,-6,-6,-2,-2,10,14,20,30,30,34,36,36,38,38,42,44,50,52,64,68,82,90,90,98},new int[]{-98,-88,-82,-80,-80,-78,-76,-72,-70,-66,-66,-58,-56,-52,-52,-50,-50,-44,-42,-42,-32,-32,-30,-26,-22,-20,-20,-2,0,10,12,18,20,24,24,26,36,38,42,56,66,74,76,78,78,84,86,96,98},new int[]{-94,-94,-94,-80,-76,-74,-68,-56,-52,-50,-44,-42,-38,-36,-34,-28,-26,-24,-16,-2,0,4,8,14,16,20,22,32,34,38,46,46,48,50,52,54,62,64,66,66,72,76,78,78,80,82,82,84,94},new int[]{-98,-98,-90,-86,-80,-78,-76,-74,-74,-72,-72,-60,-58,-54,-50,-46,-32,-24,-22,-18,-18,-14,-12,-12,-10,-8,8,14,24,30,36,46,48,50,58,58,62,66,66,74,74,74,78,78,80,84,86,90,92},new int[]{-98,-94,-82,-80,-72,-64,-60,-58,-48,-46,-46,-40,-32,-26,-24,-16,-14,-12,-10,-8,-6,-4,-4,2,4,4,12,12,14,26,34,36,40,46,48,54,66,66,66,66,66,72,78,80,80,80,94,96,98},new int[]{-96,-92,-86,-72,-70,-70,-68,-68,-66,-64,-62,-56,-50,-44,-32,-30,-28,-24,-12,-4,-4,-4,2,10,16,18,18,22,32,32,36,36,40,42,46,46,50,50,50,50,52,54,64,68,70,72,74,90,96},new int[]{-98,-98,-98,-90,-86,-82,-64,-60,-58,-54,-48,-36,-36,-32,-30,-28,-18,-16,-14,-6,-2,4,6,6,10,12,14,18,24,32,34,46,48,50,52,58,66,68,70,80,80,82,84,84,86,92,94,96,98},new int[]{-98,-96,-88,-86,-86,-86,-86,-86,-84,-78,-78,-74,-72,-72,-70,-70,-70,-66,-64,-56,-42,-40,-38,-36,-34,-32,-30,-28,-26,-20,-8,-6,0,2,2,14,24,30,34,36,44,50,52,60,66,68,74,78,86},new int[]{-96,-86,-72,-72,-70,-70,-68,-68,-64,-58,-58,-58,-54,-54,-52,-48,-46,-40,-38,-28,-14,-10,-6,-4,0,10,10,12,16,18,18,20,20,22,34,34,40,40,46,46,58,58,62,66,68,68,72,84,92},new int[]{-96,-90,-88,-88,-82,-82,-76,-74,-70,-68,-62,-56,-52,-48,-46,-38,-22,-22,-16,-12,-8,0,4,8,14,20,22,24,28,34,36,38,44,46,48,58,66,68,68,76,84,84,86,86,88,88,90,92,94},new int[]{-96,-96,-96,-94,-90,-88,-88,-84,-76,-72,-72,-58,-54,-52,-52,-50,-40,-38,-32,-12,-12,-6,-4,-2,0,2,2,10,12,22,28,28,30,34,42,42,54,56,58,64,70,70,74,74,84,86,88,88,90},new int[]{-94,-92,-84,-82,-82,-70,-66,-64,-60,-60,-58,-58,-54,-52,-52,-42,-36,-32,-30,-28,-26,-24,-22,-20,-16,-12,0,4,6,8,14,20,30,32,46,54,60,62,62,64,66,68,68,70,70,72,72,76,88},new int[]{-90,-90,-90,-88,-88,-86,-78,-68,-62,-62,-60,-54,-54,-48,-48,-36,-36,-32,-28,-28,-22,-20,-6,-2,4,6,8,10,14,24,28,28,28,34,34,36,44,52,54,54,66,70,70,72,78,80,84,88,88},new int[]{-98,-94,-94,-90,-84,-76,-72,-70,-68,-68,-60,-54,-54,-48,-46,-46,-44,-34,-28,-28,-26,-12,-8,-4,2,6,6,8,14,32,32,38,38,40,44,46,46,50,50,52,54,58,60,62,70,78,86,92,92},new int[]{-98,-94,-94,-92,-90,-86,-82,-76,-74,-74,-66,-66,-66,-60,-60,-60,-56,-54,-50,-38,-30,-28,-18,-16,-16,-2,0,6,14,16,16,18,28,30,30,32,34,40,46,52,52,54,60,70,82,84,88,90,94},new int[]{-96,-88,-84,-80,-78,-78,-78,-68,-62,-60,-52,-44,-36,-36,-36,-34,-32,-32,-30,-26,-22,-14,-10,-6,-4,-4,0,0,0,10,12,14,14,16,24,34,38,44,52,54,54,56,58,60,64,66,66,92,98},new int[]{-98,-88,-80,-80,-74,-72,-70,-68,-64,-62,-62,-62,-58,-56,-52,-50,-50,-46,-34,-30,-30,-26,-18,-12,4,10,14,22,24,30,32,38,42,42,46,56,56,58,68,72,80,82,86,90,90,92,96,98,98},new int[]{-96,-92,-92,-90,-90,-90,-88,-82,-82,-82,-80,-68,-64,-60,-50,-34,-30,-16,-10,-10,-8,-4,-4,-2,0,18,20,24,24,24,30,30,36,38,38,40,42,42,44,48,52,52,56,76,84,88,92,94,98},new int[]{-98,-90,-82,-80,-74,-74,-72,-72,-72,-72,-64,-60,-56,-56,-56,-52,-40,-38,-24,-20,-18,-18,-12,-10,-6,10,18,22,24,24,26,26,30,34,40,40,44,50,58,60,62,64,70,76,80,80,86,88,96},new int[]{-96,-94,-86,-82,-72,-68,-68,-64,-62,-56,-54,-50,-50,-48,-44,-26,-20,-16,-10,-8,-6,6,8,10,10,10,16,20,28,28,32,40,42,44,44,46,46,48,58,62,72,76,80,84,86,88,92,96,98},new int[]{-96,-94,-94,-94,-92,-92,-90,-84,-82,-78,-76,-74,-74,-62,-58,-58,-58,-42,-42,-22,-20,-14,-14,-12,-4,-2,4,4,4,8,16,20,24,26,32,40,42,46,52,54,56,56,60,60,62,62,82,90,96},new int[]{-98,-96,-96,-76,-70,-66,-54,-54,-52,-50,-46,-40,-36,-34,-32,-30,-28,-28,-26,-26,-22,-20,-18,-6,6,10,20,22,28,30,30,32,32,34,38,42,46,54,58,70,76,76,84,90,94,94,98,98,98},new int[]{-90,-86,-82,-72,-70,-70,-66,-62,-60,-58,-54,-54,-40,-36,-32,-30,-28,-26,-26,-24,-16,-14,-10,-8,-8,-8,-8,4,6,8,14,16,18,18,22,26,30,58,66,82,84,92,92,94,96,96,96,96,98},new int[]{-92,-86,-80,-74,-68,-66,-64,-64,-52,-44,-36,-34,-32,-30,-26,-22,-20,-18,-14,-12,-8,2,10,10,12,16,24,32,32,44,46,48,52,52,54,66,68,70,72,74,82,84,88,90,94,94,96,96,96},new int[]{-92,-90,-80,-78,-78,-78,-74,-66,-50,-50,-46,-46,-44,-44,-40,-38,-34,-32,-32,-30,-18,-18,-16,-14,-12,4,10,10,10,18,20,20,22,24,24,26,26,46,46,48,48,52,58,62,64,72,80,96,96},new int[]{-98,-96,-94,-92,-88,-86,-84,-82,-76,-76,-60,-58,-58,-58,-56,-50,-48,-38,-34,-30,-20,-16,-16,-10,-4,-2,10,12,18,26,32,34,48,48,52,64,64,68,70,74,76,78,80,90,92,92,92,94,96},new int[]{-96,-88,-88,-82,-76,-70,-62,-58,-56,-48,-48,-38,-36,-30,-18,-18,-16,-16,-14,-12,-6,4,8,10,10,12,14,24,28,28,34,38,44,50,58,60,62,66,66,72,74,76,76,78,78,84,86,88,96},new int[]{-98,-94,-94,-94,-90,-86,-78,-74,-68,-66,-62,-58,-56,-54,-52,-52,-48,-44,-44,-44,-30,-26,-26,-12,-4,2,4,4,6,6,12,12,14,16,16,22,22,30,30,34,36,42,50,50,64,70,80,88,98},new int[]{-98,-96,-96,-94,-88,-84,-58,-56,-52,-48,-44,-30,-26,-26,-20,-18,-16,-8,-8,-8,-6,-6,-4,-4,-2,0,6,12,12,14,24,34,42,46,48,56,60,62,62,72,72,80,84,88,88,90,90,94,96},new int[]{-98,-90,-82,-78,-70,-68,-64,-62,-56,-52,-50,-44,-44,-42,-36,-26,-24,-22,-12,-10,-6,-4,0,2,6,10,18,32,32,36,38,42,48,52,54,56,62,64,66,66,66,66,70,72,74,74,78,86,92},new int[]{-96,-90,-88,-78,-74,-72,-70,-68,-66,-60,-58,-56,-56,-50,-50,-44,-36,-26,-24,-18,-16,-16,-12,-6,2,6,8,10,10,18,18,22,24,26,42,46,64,64,66,72,74,74,76,88,94,94,96,98,98},new int[]{-94,-82,-78,-78,-76,-64,-64,-58,-58,-56,-56,-52,-44,-42,-38,-36,-22,-16,-14,-6,-2,4,4,8,8,12,14,14,14,16,16,22,30,34,38,42,44,58,62,66,66,68,76,78,80,80,84,90,98}});
    param0.add(new int[][]{new int[]{0,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,0,1,0,0,0,0},new int[]{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,0,0,1,1,1,0,0,1,0,0,0},new int[]{0,0,1,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,0,1,1,0,0,1,0,1,0,0,1,0,0,1,0,1,1,0},new int[]{0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,1,1,1,1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,0,1,1,1,1,1,0,0,1,0},new int[]{0,1,0,1,1,0,0,0,1,1,0,1,0,1,1,0,0,1,0,0,0,0,1,1,0,1,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,0,1,0,0},new int[]{0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,1,1,0,0,0},new int[]{1,1,0,1,0,1,1,0,0,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,0,0,1,1,1,1,0,1,0,1,1,0,0},new int[]{0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,0,1,0,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,1,1,1},new int[]{1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,1},new int[]{0,0,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1,0,0,0,1,1,1,1,0,0,0,0,1},new int[]{0,0,1,0,0,1,0,1,0,0,1,0,0,1,1,0,1,0,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0},new int[]{1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,0,1,1,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,1,1,0},new int[]{1,0,1,0,0,1,0,0,0,1,1,1,1,1,0,0,1,0,1,0,1,1,0,0,0,0,0,1,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0},new int[]{0,0,1,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,1,1,1,0,0,1,1,0,1,0,1,0,1},new int[]{1,1,0,1,1,0,1,0,0,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1},new int[]{0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1},new int[]{1,1,1,0,0,0,1,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1,0},new int[]{1,1,1,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,1,1,1,0,1},new int[]{0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1,0,0,1,1,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0},new int[]{1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,1,1,0},new int[]{1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,1,0},new int[]{1,1,0,0,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0},new int[]{1,0,1,1,0,1,1,0,0,1,1,0,1,1,0,1,0,1,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1},new int[]{1,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,0,0,1,0,0,1,1,0,0,1,1,0,0,1,1,1,1,0,1,1,0,0,1,1,1,0},new int[]{1,1,1,1,0,0,0,0,1,1,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,1,0,0,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,1,0},new int[]{0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0},new int[]{0,1,0,1,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,1,1,0},new int[]{1,1,0,0,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,1,1,1,0,1,1,0},new int[]{1,1,1,1,1,0,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,1},new int[]{1,1,1,1,0,0,0,0,1,0,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,1,0,1,1,1,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0},new int[]{1,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,1,0,1,1,1},new int[]{0,1,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,0},new int[]{0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,1,0,0,1},new int[]{1,1,0,0,0,0,0,0,1,0,1,1,0,0,0,0,1,1,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,0,0,1,1,1,0,0,1,0,0,0,1,1},new int[]{0,1,0,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,0,1,1,0,1,0,0,1,1,0,0,1,1,0},new int[]{0,0,0,0,0,1,0,1,1,1,1,0,1,1,0,0,0,0,0,0,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1,0,1,1,0,0,1,1,0,0,1,0},new int[]{0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0,1,1,1,1},new int[]{1,0,1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,0,0,0,1,0,1},new int[]{1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,0,1},new int[]{0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,0,0},new int[]{1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,0,1,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,0},new int[]{0,0,1,0,1,0,1,1,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1},new int[]{0,0,0,1,0,1,1,1,0,0,0,1,1,1,0,0,0,1,0,1,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,0,0,1,0,1,1,0,1},new int[]{0,1,1,1,0,0,1,0,0,0,1,1,0,0,0,1,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,0,0,0,1},new int[]{0,0,0,0,0,1,0,1,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,1,0,0,1,1,0,0,0,1,1,0,0,1},new int[]{0,0,1,1,1,1,0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1}});
    param0.add(new int[][]{new int[]{13,16,26,38,44,71,73},new int[]{16,28,39,47,48,59,61},new int[]{15,30,50,59,60,89,90},new int[]{24,61,63,71,72,76,83},new int[]{14,36,39,42,64,76,77},new int[]{4,6,11,24,34,36,58},new int[]{22,35,63,70,81,91,98}});
    param0.add(new int[][]{new int[]{-48,-22,-52,-86,-22},new int[]{-54,-6,-16,-84,-34},new int[]{-46,-16,-80,-82,-38},new int[]{-44,98,-54,-32,-88},new int[]{42,52,38,-20,-36}});
    param0.add(new int[][]{new int[]{0,0,0,0,0,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,1,1,1,1},new int[]{0,0,0,0,0,1,1,1,1,1,1,1},new int[]{0,0,0,0,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,1,1,1,1,1,1,1},new int[]{0,0,0,0,1,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,1,1,1,1,1,1},new int[]{0,0,0,0,0,1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,1,1,1,1,1},new int[]{0,0,0,0,0,0,0,0,1,1,1,1}});
    param0.add(new int[][]{new int[]{62,15,2,68,63,42,57,46,37,30,1,51,47,75,50,24,48,56,93,9,50,79,58,74,81,64,63,60,49,24,46,55,89,10,49,46,17,86,24,51,69,21,16,97,66,14},new int[]{95,91,93,6,64,52,1,29,77,42,16,76,40,30,32,7,36,72,1,94,12,25,11,75,52,95,64,4,54,78,40,67,81,92,5,42,65,94,59,12,35,75,82,83,72,47},new int[]{69,96,79,34,12,8,27,58,49,56,43,17,26,87,1,19,99,48,80,25,56,40,42,63,92,27,76,55,15,2,30,81,79,4,15,52,21,94,80,27,93,33,44,20,45,34},new int[]{18,47,49,73,19,87,86,72,52,21,36,27,96,2,87,35,22,20,97,92,69,13,15,95,80,58,84,66,56,12,57,36,90,25,14,43,43,80,2,53,42,65,52,42,5,48},new int[]{85,40,51,5,9,71,80,70,2,18,87,36,78,90,57,60,27,92,15,64,47,22,99,53,87,28,97,94,28,83,64,10,10,34,30,90,17,87,31,7,29,68,29,69,47,35},new int[]{15,32,84,9,45,6,37,97,12,69,91,45,39,58,49,85,76,2,48,71,81,88,16,71,49,32,68,5,23,65,93,47,88,59,43,43,36,59,52,77,1,25,36,86,26,42},new int[]{39,15,66,15,13,29,80,10,75,3,21,65,41,19,76,82,64,55,63,46,24,94,40,75,24,20,2,86,90,24,53,70,65,90,45,70,96,98,68,60,12,31,27,57,63,17},new int[]{79,58,4,37,50,72,71,69,45,86,47,25,98,59,63,16,13,97,66,2,8,13,4,54,96,1,80,3,35,15,62,20,74,58,80,65,85,37,74,6,93,29,10,19,80,61},new int[]{53,59,23,20,92,20,65,17,71,81,41,50,37,86,75,62,21,49,59,34,56,94,41,71,70,94,44,6,25,19,37,3,13,39,86,98,19,30,52,26,35,25,65,74,9,69},new int[]{15,92,20,89,35,8,50,32,17,2,21,64,76,26,9,49,25,63,17,51,58,1,97,3,28,80,11,89,23,86,9,27,5,52,31,62,77,63,86,41,59,19,28,78,6,63},new int[]{76,97,67,74,17,13,95,60,16,63,87,95,84,66,82,69,80,44,54,32,29,37,47,62,78,79,45,10,63,11,20,53,95,72,40,75,89,81,1,37,56,15,85,93,84,9},new int[]{72,60,72,79,28,8,48,76,89,84,89,46,42,83,65,90,71,93,64,50,55,88,66,29,6,6,47,99,61,98,24,57,4,83,56,56,46,21,46,33,78,85,15,28,80,33},new int[]{49,8,68,50,35,16,35,44,22,80,94,48,98,13,43,79,28,68,15,99,5,27,62,63,85,66,55,31,44,48,73,58,71,50,94,22,19,79,76,13,97,27,91,19,47,12},new int[]{52,75,69,55,13,16,39,7,82,28,77,88,84,98,47,21,21,43,40,92,82,92,33,94,3,21,42,47,89,40,59,78,13,97,62,96,74,69,95,73,90,11,67,10,48,47},new int[]{37,21,84,6,27,11,42,18,62,58,81,7,9,71,77,38,69,12,16,61,2,44,81,71,2,99,22,38,30,51,39,11,62,73,95,74,13,87,33,17,23,8,90,45,36,73},new int[]{80,14,37,80,75,12,38,69,25,91,72,14,3,36,97,93,61,20,22,9,56,89,37,99,9,50,59,95,67,25,48,36,91,66,48,61,71,13,50,54,51,29,58,48,14,19},new int[]{64,64,97,27,3,7,54,36,57,24,82,5,83,49,78,87,87,93,70,62,68,26,40,84,82,76,98,27,41,71,23,56,3,46,85,39,62,92,73,74,16,79,40,24,91,63},new int[]{88,29,39,88,15,76,44,40,66,67,26,9,61,5,24,71,8,56,35,89,71,12,72,54,26,84,57,58,46,73,92,24,20,59,70,86,84,15,98,51,29,15,74,7,19,64},new int[]{14,46,80,84,53,57,50,32,23,48,35,83,89,10,67,51,96,63,84,18,6,41,48,79,66,17,17,45,51,7,65,79,29,34,92,17,45,36,2,36,66,30,65,4,55,61},new int[]{23,37,69,52,89,17,78,39,81,83,94,61,33,11,46,34,27,35,55,1,22,99,91,24,56,28,70,88,23,48,77,57,57,72,69,79,95,58,37,68,17,66,11,82,97,20},new int[]{24,46,12,76,76,15,6,97,22,95,83,52,69,59,17,24,54,85,60,41,2,84,71,76,71,27,36,54,79,32,66,65,27,15,39,30,38,58,6,66,73,31,73,74,64,51},new int[]{71,37,75,62,93,88,55,77,22,54,67,34,50,89,66,77,17,54,1,53,83,3,74,37,41,38,48,39,25,46,72,61,70,77,7,58,5,77,60,64,95,22,81,95,53,14},new int[]{52,25,79,20,16,26,40,49,23,82,56,61,40,89,99,58,90,17,22,20,1,14,5,99,34,63,71,7,51,56,8,3,8,39,45,90,97,24,45,77,51,57,41,59,47,15},new int[]{98,5,15,87,54,20,2,88,73,98,90,4,79,94,74,26,3,91,65,28,25,93,61,63,3,97,15,40,1,79,88,71,15,55,94,93,38,56,10,41,68,28,85,74,71,19},new int[]{10,27,56,25,36,22,54,74,28,72,53,19,66,49,49,56,94,55,24,82,54,66,1,7,37,45,49,85,34,51,91,74,64,28,87,81,39,42,93,60,43,10,85,12,7,62},new int[]{73,51,16,10,70,67,50,75,37,60,45,31,57,94,44,51,23,74,16,79,78,57,63,90,28,24,63,5,61,2,20,86,57,46,42,5,34,72,35,68,37,6,19,15,48,93},new int[]{70,43,61,32,77,46,11,98,66,70,44,73,51,53,55,69,54,3,65,25,75,37,47,44,78,78,3,98,73,71,34,54,80,69,20,35,1,27,42,18,93,96,60,9,80,57},new int[]{2,31,55,74,66,86,59,31,40,18,55,86,79,74,45,19,83,26,24,28,15,34,34,28,66,68,94,87,19,66,67,48,38,39,67,75,23,28,23,10,65,75,50,23,85,55},new int[]{91,22,56,89,33,23,8,81,56,97,2,88,94,38,61,8,56,85,68,31,99,30,75,61,23,68,10,95,53,57,55,42,48,97,23,40,61,99,30,54,18,66,83,58,6,35},new int[]{46,84,95,99,63,16,14,13,55,83,6,77,77,40,1,85,53,14,66,46,99,67,42,55,11,27,40,38,81,54,80,3,52,77,5,22,75,50,95,54,88,27,1,85,6,60},new int[]{38,32,53,70,13,71,48,20,37,38,25,23,58,93,34,66,47,71,50,64,11,60,45,49,57,25,42,75,78,97,58,31,83,60,53,72,45,71,22,43,79,1,81,8,62,39},new int[]{53,8,61,2,80,52,70,9,47,23,87,99,41,89,23,54,5,50,50,96,51,30,41,93,90,77,30,4,63,52,89,30,72,96,75,55,74,12,67,62,3,38,53,62,80,80},new int[]{88,65,51,42,27,28,91,20,8,18,46,12,36,12,41,29,31,18,27,84,84,83,96,70,2,3,40,53,1,39,16,29,8,23,38,71,89,87,92,83,83,57,3,64,62,51},new int[]{76,38,28,18,53,19,90,48,7,74,89,6,10,5,29,51,59,32,33,66,4,90,39,9,90,77,35,48,29,58,35,14,72,89,17,75,45,8,54,58,40,65,6,90,26,47},new int[]{93,31,76,38,69,20,19,44,28,53,95,64,50,11,27,64,77,18,24,1,46,8,77,72,48,14,87,28,54,9,63,68,67,59,37,20,17,74,6,30,49,65,50,80,75,77},new int[]{76,40,73,71,21,7,8,38,60,4,40,32,18,36,82,31,29,74,73,19,51,98,46,74,98,53,24,66,7,14,71,95,4,86,60,14,80,28,34,18,49,68,76,55,72,35},new int[]{66,6,48,50,62,34,10,41,14,93,60,58,8,51,31,89,42,67,29,75,90,98,58,4,87,82,29,27,38,13,70,4,40,30,81,29,57,61,90,10,82,36,9,32,45,87},new int[]{76,45,58,23,90,81,1,48,12,36,90,35,36,83,19,6,17,6,90,88,26,12,53,49,23,13,52,17,30,92,22,83,64,1,82,71,67,30,54,67,64,93,93,8,45,71},new int[]{65,37,45,41,91,59,22,56,29,22,12,44,56,7,73,87,77,98,9,38,37,62,86,66,53,64,73,86,8,20,8,3,46,51,11,53,50,57,26,93,80,41,34,70,82,82},new int[]{77,1,52,73,66,59,96,50,60,63,38,44,26,95,62,99,37,34,8,44,31,10,82,75,82,92,54,61,3,52,55,7,48,22,43,71,50,96,27,56,44,66,48,25,27,22},new int[]{5,86,67,70,46,7,43,52,7,19,85,27,99,55,1,48,16,41,2,47,59,51,21,19,80,80,8,41,51,75,74,49,54,48,73,15,69,24,96,19,97,23,28,90,60,50},new int[]{76,65,97,12,56,95,81,27,85,46,42,56,77,90,55,6,91,41,81,93,62,83,56,21,31,28,10,28,47,92,29,85,9,30,94,62,88,86,52,16,30,50,47,1,51,11},new int[]{83,14,96,9,59,84,27,94,5,20,93,58,99,71,9,5,78,38,97,97,42,88,50,51,28,64,62,32,22,50,18,57,12,61,86,72,35,53,64,42,90,32,46,84,82,65},new int[]{28,99,16,15,46,15,57,32,82,90,2,29,28,8,41,33,74,61,87,64,7,51,79,30,70,33,88,9,24,7,61,22,5,12,37,19,91,38,55,23,54,62,82,8,44,73},new int[]{30,77,76,3,41,88,95,36,78,76,33,86,54,38,92,36,65,99,67,8,72,33,71,88,8,63,43,89,57,6,20,74,52,50,61,66,52,3,3,60,28,6,90,51,60,15},new int[]{32,86,94,46,87,40,20,75,67,86,63,63,48,42,81,69,30,11,45,18,58,68,58,79,95,51,81,1,88,58,49,75,89,60,52,24,80,70,47,17,45,94,69,17,11,97}});
    List<int [ ]> param1 = new ArrayList<>();
    param1.add(new int[]{31,50,50,68,69,80,87});
    param1.add(new int[]{-74,-50,-90,-52,96,78,-16,14,-14,66,-50,74,-34,-88,84,80,34,18,-38,62,56,-48,-22,94,94,94,92,-46,-32,10,-48,46,20,80,32,30,88,60});
    param1.add(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
    param1.add(new int[]{23,36,42,49,50,88,97,51,1,27,4,72,11,61,24,49,75,29,96,16,11,65,13,22,13,23,84,23,20,63,35,76,22});
    param1.add(new int[]{-96,-90,-90,-86,-86,-86,-84,-76,-76,-74,-72,-70,-52,-50,-34,-32,-26,-20,-16,-14,-10,-8,-8,-6,4,12,14,16,18,24,26,32,34,38,42,42,48,48,48,48,64,66,70,76,76,82,86,86,96});
    param1.add(new int[]{0,1,1,1,1,0,1,1,1,0,0,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,1,1,0,1,1,0,0,0});
    param1.add(new int[]{3,9,32,55,78,85,90});
    param1.add(new int[]{48,-68,0,-54,-80});
    param1.add(new int[]{0,0,0,0,0,0,0,0,1,1,1,1});
    param1.add(new int[]{19,39,31,50,61,70,43,64,45,82,49,80,21,37,96,30,42,82,96,30,22,26,42,88,57,12,59,58,83,64,66,2,37,60,5,76,20,81,10,57,70,74,65,72,15,84});
    List<Integer> param2 = new ArrayList<>();
    param2.add(6);
    param2.add(25);
    param2.add(28);
    param2.add(25);
    param2.add(37);
    param2.add(43);
    param2.add(5);
    param2.add(4);
    param2.add(7);
    param2.add(34);
    List<Integer> param3 = new ArrayList<>();
    param3.add(5);
    param3.add(20);
    param3.add(28);
    param3.add(30);
    param3.add(38);
    param3.add(32);
    param3.add(3);
    param3.add(4);
    param3.add(10);
    param3.add(25);
    List<Integer> param4 = new ArrayList<>();
    param4.add(4);
    param4.add(25);
    param4.add(32);
    param4.add(19);
    param4.add(26);
    param4.add(35);
    param4.add(3);
    param4.add(3);
    param4.add(9);
    param4.add(32);
    for(int i = 0; i < param0.size(); ++i)
    {
        if(f_filled(param0.get(i),param1.get(i),param2.get(i),param3.get(i),param4.get(i)) == f_gold(param0.get(i),param1.get(i),param2.get(i),param3.get(i),param4.get(i)))
        {
            n_success+=1;
        }
    }
    System.out.println("#Results:" + n_success + ", " + param0.size());
}
}