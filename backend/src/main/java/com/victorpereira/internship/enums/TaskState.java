package com.victorpereira.internship.enums;

public enum TaskState {

	OPEN(1),
	DONE(2);
	
	private int code;

	private TaskState(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TaskState toEnum(Integer code) {
		if (code == null)
			return null;

		for (TaskState x : TaskState.values()) {
			if (code.equals(x.getCode()))
				return x;
		}
		throw new IllegalArgumentException("Invalid Id: " + code);
	}
}
