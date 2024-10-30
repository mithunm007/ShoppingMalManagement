import React, { useState, useEffect } from 'react';
import EmployeeService from './EmployeeService';
import './Employee.css';

const Employee = () => {
  const [employees, setEmployees] = useState([]);
  const [empId, setEmpId] = useState('');
  const [empName, setEmpName] = useState('');
  const [empRole, setEmpRole] = useState('');
  const [empSalary, setEmpSalary] = useState('');
  const [error, setError] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {
      const data = await EmployeeService.getAllEmployees();
      setEmployees(data);
    } catch (err) {
      setError('Failed to fetch employees');
    }
  };

  const handleAddEmployee = async () => {
    const employeeData = { empId, empName, empRole, empSalary };

    try {
      if (!empName || !empRole || !empSalary) {
        setError('All fields are required');
        return;
      }

      if (isEditing) {
        await EmployeeService.updateEmployee(empId, employeeData);
      } else {
        await EmployeeService.createEmployee(employeeData);
      }

      fetchEmployees();
      clearForm();
    } catch (err) {
      setError('Failed to create or update employee');
    }
  };

  const handleEditEmployee = async (id) => {
    try {
      const employee = await EmployeeService.getEmployeeById(id);
      setEmpId(employee.empId);
      setEmpName(employee.empName);
      setEmpRole(employee.empRole);
      setEmpSalary(employee.empSalary);
      setIsEditing(true);
    } catch (err) {
      setError('Failed to fetch employee details');
    }
  };

  const handleDeleteEmployee = async (id) => {
    try {
      await EmployeeService.deleteEmployee(id);
      fetchEmployees();
    } catch (err) {
      setError('Failed to delete employee');
    }
  };

  const clearForm = () => {
    setEmpId('');
    setEmpName('');
    setEmpRole('');
    setEmpSalary('');
    setIsEditing(false);
  };

  return (
    <div className="employee-container">
      <h2>{isEditing ? 'Edit Employee' : 'Add Employee'}</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Employee ID"
          value={empId}
          onChange={(e) => setEmpId(e.target.value)}
          disabled={isEditing} // Disable editing of empId when in update mode
        />
        <input
          type="text"
          placeholder="Employee Name"
          value={empName}
          onChange={(e) => setEmpName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Employee Role"
          value={empRole}
          onChange={(e) => setEmpRole(e.target.value)}
        />
        <input
          type="number"
          placeholder="Employee Salary"
          value={empSalary}
          onChange={(e) => setEmpSalary(e.target.value)}
        />
        <button onClick={handleAddEmployee}>
          {isEditing ? 'Update Employee' : 'Add Employee'}
        </button>
      </div>

      <h3>All Employees</h3>
      <div className="employee-list">
        {employees.map((employee) => (
          <div key={employee.empId} className="employee-item">
            <h4>
              ID: {employee.empId} <br />
              Name: {employee.empName} <br />
              Role: {employee.empRole} <br />
              Salary: {employee.empSalary}
            </h4>
            <button onClick={() => handleEditEmployee(employee.empId)}>Edit</button>
            <button onClick={() => handleDeleteEmployee(employee.empId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Employee;
