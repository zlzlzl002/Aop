package test.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // Spring bean container 에서 관리
@Component
public class WriteServiceImpl implements WriteService{

	@Override
	public void write() {
		System.out.println("글쓰기 작업중....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFriend() {
		System.out.println("친구에게 글쓰기 작업중....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeToTeacher(String name) {
		System.out.println(name+" 이(가) 선생님에게 글쓰기 작업중...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> writeToMother() {
		System.out.println("엄마에게 글쓰기 작업중..");	// Before
		
		Map<String, Object> map= new HashMap<>();
		
		map.put("msg", "Hello, MaMa!");
		
		return map; // => map=obj => Object obj=joinPoint.proceed();
		// After 는 return 이후
	}

}
