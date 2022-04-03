/**
 * 
 */
package us.vonhaden.ethwatch.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author blake
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
	private String status;
	private String message;
	private Ethbtc result;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Ethbtc getResult() {
		return result;
	}
	public void setResult(Ethbtc result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return result.getEthusd().toPlainString();
	}
	public BigDecimal getUSD() {
		return result.getEthusd();
	}
}
