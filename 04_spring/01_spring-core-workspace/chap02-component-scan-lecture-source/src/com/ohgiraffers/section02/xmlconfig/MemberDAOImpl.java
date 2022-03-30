package com.ohgiraffers.section02.xmlconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
//value는 생략가능하다.
/*이름(id)를 설정하지 않으면 class의 앞 글자를 소문자로 하여 bean으로 생성한다.*/
@Component(value="memberDAO")
public class MemberDAOImpl implements MemberDAO {

	private final Map<Integer, MemberDTO> memberMap;
	
	public MemberDAOImpl() {
		
		memberMap = new HashMap<>();
		memberMap.put(1, new MemberDTO(1,"user01","pass01","홍길동"));
		memberMap.put(2, new MemberDTO(2,"user02","pass02","유관순"));
	}

	@Override
	public MemberDTO selectMember(int sequence) {
	
		return memberMap.get(sequence);
	}

	@Override
	public boolean insertMember(MemberDTO newMember) {
		
		int before = memberMap.size();
		
		memberMap.put(newMember.getSequence(), newMember);
		
		int after = memberMap.size();
	
		return (after > before)? true : false;
	}
	
	
	
}
