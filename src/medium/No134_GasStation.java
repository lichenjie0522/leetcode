package medium;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author lichenjie0522
 *
 */
public class No134_GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
			return -1;
		}
		int curGas = 0;
		int totalGas = 0;
		int result = 0;
		for (int i = 0; i < gas.length; ++i) {
			curGas += gas[i] - cost[i];
			totalGas += gas[i] - cost[i];
			if (curGas < 0) {
				curGas = 0;
				result = i + 1;
			}
		}
		if (totalGas < 0) {
			return -1;
		}
		return result;
	}
}
