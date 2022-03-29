package com.ohgiraffers.model.dto;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeDTO implements java.io.Serializable {

	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private String managerId;
	private java.sql.Date hireDate;
	private java.sql.Date entDate;
	private String entYn;
	
	
	
	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmployeeDTO(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}
	
	
	
	public int length() {
		return deptCode.length();
	}
	public boolean isEmpty() {
		return deptCode.isEmpty();
	}
	public char charAt(int index) {
		return deptCode.charAt(index);
	}
	public int codePointAt(int index) {
		return deptCode.codePointAt(index);
	}
	public int codePointBefore(int index) {
		return deptCode.codePointBefore(index);
	}
	public int codePointCount(int beginIndex, int endIndex) {
		return deptCode.codePointCount(beginIndex, endIndex);
	}
	public int offsetByCodePoints(int index, int codePointOffset) {
		return deptCode.offsetByCodePoints(index, codePointOffset);
	}
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		deptCode.getChars(srcBegin, srcEnd, dst, dstBegin);
	}
	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		deptCode.getBytes(srcBegin, srcEnd, dst, dstBegin);
	}
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return deptCode.getBytes(charsetName);
	}
	public byte[] getBytes(Charset charset) {
		return deptCode.getBytes(charset);
	}
	public byte[] getBytes() {
		return deptCode.getBytes();
	}
	public boolean equals(Object anObject) {
		return deptCode.equals(anObject);
	}
	public boolean contentEquals(StringBuffer sb) {
		return deptCode.contentEquals(sb);
	}
	public boolean contentEquals(CharSequence cs) {
		return deptCode.contentEquals(cs);
	}
	public boolean equalsIgnoreCase(String anotherString) {
		return deptCode.equalsIgnoreCase(anotherString);
	}
	public int compareTo(String anotherString) {
		return deptCode.compareTo(anotherString);
	}
	public int compareToIgnoreCase(String str) {
		return deptCode.compareToIgnoreCase(str);
	}
	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return deptCode.regionMatches(toffset, other, ooffset, len);
	}
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return deptCode.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}
	public boolean startsWith(String prefix, int toffset) {
		return deptCode.startsWith(prefix, toffset);
	}
	public boolean startsWith(String prefix) {
		return deptCode.startsWith(prefix);
	}
	public boolean endsWith(String suffix) {
		return deptCode.endsWith(suffix);
	}
	public int hashCode() {
		return deptCode.hashCode();
	}
	public int indexOf(int ch) {
		return deptCode.indexOf(ch);
	}
	public int indexOf(int ch, int fromIndex) {
		return deptCode.indexOf(ch, fromIndex);
	}
	public int lastIndexOf(int ch) {
		return deptCode.lastIndexOf(ch);
	}
	public int lastIndexOf(int ch, int fromIndex) {
		return deptCode.lastIndexOf(ch, fromIndex);
	}
	public int indexOf(String str) {
		return deptCode.indexOf(str);
	}
	public int indexOf(String str, int fromIndex) {
		return deptCode.indexOf(str, fromIndex);
	}
	public int lastIndexOf(String str) {
		return deptCode.lastIndexOf(str);
	}
	public int lastIndexOf(String str, int fromIndex) {
		return deptCode.lastIndexOf(str, fromIndex);
	}
	public String substring(int beginIndex) {
		return deptCode.substring(beginIndex);
	}
	public String substring(int beginIndex, int endIndex) {
		return deptCode.substring(beginIndex, endIndex);
	}
	public CharSequence subSequence(int beginIndex, int endIndex) {
		return deptCode.subSequence(beginIndex, endIndex);
	}
	public String concat(String str) {
		return deptCode.concat(str);
	}
	public String replace(char oldChar, char newChar) {
		return deptCode.replace(oldChar, newChar);
	}
	public boolean matches(String regex) {
		return deptCode.matches(regex);
	}
	public boolean contains(CharSequence s) {
		return deptCode.contains(s);
	}
	public String replaceFirst(String regex, String replacement) {
		return deptCode.replaceFirst(regex, replacement);
	}
	public String replaceAll(String regex, String replacement) {
		return deptCode.replaceAll(regex, replacement);
	}
	public String replace(CharSequence target, CharSequence replacement) {
		return deptCode.replace(target, replacement);
	}
	public String[] split(String regex, int limit) {
		return deptCode.split(regex, limit);
	}
	public String[] split(String regex) {
		return deptCode.split(regex);
	}
	public String toLowerCase(Locale locale) {
		return deptCode.toLowerCase(locale);
	}
	public String toLowerCase() {
		return deptCode.toLowerCase();
	}
	public String toUpperCase(Locale locale) {
		return deptCode.toUpperCase(locale);
	}
	public String toUpperCase() {
		return deptCode.toUpperCase();
	}
	public String trim() {
		return deptCode.trim();
	}
	public String strip() {
		return deptCode.strip();
	}
	public String stripLeading() {
		return deptCode.stripLeading();
	}
	public String stripTrailing() {
		return deptCode.stripTrailing();
	}
	public boolean isBlank() {
		return deptCode.isBlank();
	}
	public Stream<String> lines() {
		return deptCode.lines();
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + "]";
	}
	public IntStream chars() {
		return deptCode.chars();
	}
	public IntStream codePoints() {
		return deptCode.codePoints();
	}
	public char[] toCharArray() {
		return deptCode.toCharArray();
	}
	public String intern() {
		return deptCode.intern();
	}
	public String repeat(int count) {
		return deptCode.repeat(count);
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getSalLevel() {
		return salLevel;
	}
	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public java.sql.Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}
	public java.sql.Date getEntDate() {
		return entDate;
	}
	public void setEntDate(java.sql.Date entDate) {
		this.entDate = entDate;
	}
	public String getEntYn() {
		return entYn;
	}
	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}
	
	
	
}
