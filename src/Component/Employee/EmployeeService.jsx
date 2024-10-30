import axios from 'axios';
import API_BASE_URL from '../Config';

const EmployeeService = {
  getAllEmployees: async () => {
    const response = await axios.get(`${API_BASE_URL}/employees`);
    return response.data;
  },

  getEmployeeById: async (empId) => {
    const response = await axios.get(`${API_BASE_URL}/employees/${empId}`);
    return response.data;
  },

  createEmployee: async (employee) => {
    const response = await axios.post(`${API_BASE_URL}/employees`, employee, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  updateEmployee: async (empId, employee) => {
    const response = await axios.put(`${API_BASE_URL}/employees/${empId}`, employee, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteEmployee: async (empId) => {
    await axios.delete(`${API_BASE_URL}/employees/${empId}`);
  },
};

export default EmployeeService;
