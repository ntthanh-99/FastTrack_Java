package com.spring.batch.processor;

import com.spring.batch.dto.EmployeeDTO;
import com.spring.batch.model.EmployeeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * The Class EmployeeProcessor.
 * <p>
 * Class description explaining the usage.
 * </p>
 *
 */
public class EmployeeProcessor implements ItemProcessor<EmployeeModel, EmployeeDTO> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProcessor.class);

    @Override
    public EmployeeDTO process(final EmployeeModel employeeModel) throws Exception {

        LOGGER.info("Transforming EmployeeModel(s) to EmployeeDTO(s)..");

        final EmployeeDTO employeeDTO = new EmployeeDTO(employeeModel.getEmployeeId(),employeeModel.getEmployeeName(),employeeModel.getEmployeeRole(),
                employeeModel.getSalary(),employeeModel.getYearOfExperience());

        return employeeDTO;
    }

}
