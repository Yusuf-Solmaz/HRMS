package kodlama.io.hrms.core.utilities.adapter;

 
import org.springframework.stereotype.Service;

import kodlama.io.hrms.services.mailService.FakeMailService;

@Service
	public class EmailAdapter implements EmailService{
		
		
		@Override
		public boolean isOkay(String email)
		{
			return FakeMailService.isOkay(email);
		}
		
	}
