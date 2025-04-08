package JSONLearning;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveBalanceResponse {

	@JsonProperty("leave-balance")
	private List<LeaveBalance> leaveBalance;

	public List<LeaveBalance> getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(List<LeaveBalance> leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	

}


