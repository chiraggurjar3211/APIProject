package JSONLearning;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveBalance {
	@JsonProperty("user-id")
	private String userId;
	
	@JsonProperty("user-name")
	private String userName;
	@JsonProperty("short-name")
	private String shortName;
	@JsonProperty("leave-code")
	private String leaveCode;
	@JsonProperty("leave-name")
	private String leaveName;
	private String period;
	@JsonProperty("opening-balance")
	private float openingBalance;
	@JsonProperty("closing-balance")
	private int closingBalance;
	private int credit;
	private int debit;
	private int encashed;
	private int availed;
	private int overflow;
	@JsonProperty("leave-type")
	private int leaveType;
	@JsonProperty("hourly-leave-opening-balance")
	private String hourlyLeaveOpeningBalance;
	@JsonProperty("hourly-leave-closing-balance-min")
	private String hourlyLeaveClosingBalanceMin;
	@JsonProperty("hourly-leave-credit")
	private String hourlyLeaveCredit;
	@JsonProperty("hourly-leave-debit")
	private String hourlyLeaveDebit;
	@JsonProperty("hourly-leave-encashed")
	private String hourlyLeaveEncashed;
	@JsonProperty("hourly-leave-availed-min")
	private String hourlyLeaveAvailedMin;
	@JsonProperty("hourly-leave-overflow-min")
	private String hourlyLeaveOverflowMin;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLeaveCode() {
		return leaveCode;
	}

	public void setLeaveCode(String leaveCode) {
		this.leaveCode = leaveCode;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public float getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
	}

	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public int getEncashed() {
		return encashed;
	}

	public void setEncashed(int encashed) {
		this.encashed = encashed;
	}

	public int getAvailed() {
		return availed;
	}

	public void setAvailed(int availed) {
		this.availed = availed;
	}

	public int getOverflow() {
		return overflow;
	}

	public void setOverflow(int overflow) {
		this.overflow = overflow;
	}

	public int getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(int leaveType) {
		this.leaveType = leaveType;
	}

	public String getHourlyLeaveOpeningBalance() {
		return hourlyLeaveOpeningBalance;
	}

	public void setHourlyLeaveOpeningBalance(String hourlyLeaveOpeningBalance) {
		this.hourlyLeaveOpeningBalance = hourlyLeaveOpeningBalance;
	}

	public String getHourlyLeaveClosingBalanceMin() {
		return hourlyLeaveClosingBalanceMin;
	}

	public void setHourlyLeaveClosingBalanceMin(String hourlyLeaveClosingBalanceMin) {
		this.hourlyLeaveClosingBalanceMin = hourlyLeaveClosingBalanceMin;
	}

	public String getHourlyLeaveCredit() {
		return hourlyLeaveCredit;
	}

	public void setHourlyLeaveCredit(String hourlyLeaveCredit) {
		this.hourlyLeaveCredit = hourlyLeaveCredit;
	}

	public String getHourlyLeaveDebit() {
		return hourlyLeaveDebit;
	}

	public void setHourlyLeaveDebit(String hourlyLeaveDebit) {
		this.hourlyLeaveDebit = hourlyLeaveDebit;
	}

	public String getHourlyLeaveEncashed() {
		return hourlyLeaveEncashed;
	}

	public void setHourlyLeaveEncashed(String hourlyLeaveEncashed) {
		this.hourlyLeaveEncashed = hourlyLeaveEncashed;
	}

	public String getHourlyLeaveAvailedMin() {
		return hourlyLeaveAvailedMin;
	}

	public void setHourlyLeaveAvailedMin(String hourlyLeaveAvailedMin) {
		this.hourlyLeaveAvailedMin = hourlyLeaveAvailedMin;
	}

	public String getHourlyLeaveOverflowMin() {
		return hourlyLeaveOverflowMin;
	}

	public void setHourlyLeaveOverflowMin(String hourlyLeaveOverflowMin) {
		this.hourlyLeaveOverflowMin = hourlyLeaveOverflowMin;
	}

}
