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
public class Ethbtc {
	private BigDecimal ethbtc;
	private String ethbtc_timestamp;
	private BigDecimal ethusd;
	private String ethusd_timestamp;
	/**
	 * @return the ethbtc
	 */
	public BigDecimal getEthbtc() {
		return ethbtc;
	}
	/**
	 * @param ethbtc the ethbtc to set
	 */
	public void setEthbtc(BigDecimal ethbtc) {
		this.ethbtc = ethbtc;
	}
	/**
	 * @return the ethbtc_timestamp
	 */
	public String getEthbtc_timestamp() {
		return ethbtc_timestamp;
	}
	/**
	 * @param ethbtc_timestamp the ethbtc_timestamp to set
	 */
	public void setEthbtc_timestamp(String ethbtc_timestamp) {
		this.ethbtc_timestamp = ethbtc_timestamp;
	}
	/**
	 * @return the ethusd
	 */
	public BigDecimal getEthusd() {
		return ethusd;
	}
	/**
	 * @param ethusd the ethusd to set
	 */
	public void setEthusd(BigDecimal ethusd) {
		this.ethusd = ethusd;
	}
	/**
	 * @return the ethusd_timestamp
	 */
	public String getEthusd_timestamp() {
		return ethusd_timestamp;
	}
	/**
	 * @param ethusd_timestamp the ethusd_timestamp to set
	 */
	public void setEthusd_timestamp(String ethusd_timestamp) {
		this.ethusd_timestamp = ethusd_timestamp;
	}

}
