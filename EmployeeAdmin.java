package SEP4;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAdmin {

	// returns a list of social security numbers, sorted in ascending order,
	// that belong to an Employee in the input table but that are not on the
	// socSecNums input list
	public static List<String> prepareSsnReport(HashMap<String, Employee> table, List<String> socSecNums) {
		// implement
		Set<String> table2List = table.keySet();
		List<String> list2Return = table2List.stream().filter(x -> !socSecNums.contains(x)).sorted(String::compareTo)
				.collect(Collectors.toList());
		return list2Return;

	}

	// return a list of Employees whose social security number is on the input list
	// socSecNums
	// and whose salary is >80000; the return list does not need to be sorted
	public static List<Employee> prepareEmpReport(HashMap<String, Employee> table, List<String> socSecNums) {
		// implement
		List<Employee> ListEmployee = table.keySet().stream().map(x -> table.get(x)).collect(Collectors.toList());
		return ListEmployee.stream().filter(x -> x.getSalary() > 80000 && socSecNums.contains(x.getSsn()))
				.collect(Collectors.toList());
	}
}