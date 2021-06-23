package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {

	  	private String jobDescription;
	    private int minSalary;
	    private int maxSalary;
	    private int openPositionCount;
	    private LocalDate applicationDeadline;
	    private int employerId;
	    private int jobPositionId;
	    private int cityId;
	    private int typeOfWorkingId;
	    private int wayOfWorkingId;
	    
}
