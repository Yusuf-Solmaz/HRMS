package kodlama.io.hrms.core.utilities.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.services.fakeMernis.FakeMernis;

@Service
public class MernisAdapter  implements MernisService {
	
	@Autowired
	FakeMernis fakeMernis;
	
	@Override
	public boolean isOkay(String identityNumber) {
		return FakeMernis.validate(identityNumber);
	}


	
}
