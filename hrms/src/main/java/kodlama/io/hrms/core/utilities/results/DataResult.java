package kodlama.io.hrms.core.utilities.results;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result{

	private T data;
	
	
	public DataResult(T data, boolean success, String message) {
		super(true,message);
		this.data=data;
	}
	
	public DataResult(T data, boolean success) {
		super(true);
		this.data=data;
	}
}
