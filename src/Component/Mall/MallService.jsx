// import axios from 'axios';
// import API_BASE_URL from '../Config';

// const MallService = {
//   getAllMalls: async () => {
//     const response = await axios.get(`${API_BASE_URL}/malls`);
//     return response.data;
//   },

//   getMallById: async (mallId) => {
//     const response = await axios.get(`${API_BASE_URL}/malls/${mallId}`);
//     return response.data;
//   },

//   createMall: async (mall) => {
//     const response = await axios.post(`${API_BASE_URL}/malls`, mall, {
//       headers: { 'Content-Type': 'application/json' },
//     });
//     return response.data;
//   },

//   updateMall: async (mallId, mall) => {
//     const response = await axios.put(`${API_BASE_URL}/malls/${mallId}`, mall, {
//       headers: { 'Content-Type': 'application/json' },
//     });
//     return response.data;
//   },

//   deleteMall: async (mallId) => {
//     await axios.delete(`${API_BASE_URL}/malls/${mallId}`);
//   },

//   getShopsByMallId: async (mallId) => {
//     const response = await axios.get(`${API_BASE_URL}/malls/${mallId}/shops`);
//     return response.data;
//   },

//   getEmployeesByShopId: async (shopId) => {
//     const response = await axios.get(`${API_BASE_URL}/shops/${shopId}/employees`);
//     return response.data;
//   },
// };

// export default MallService;



import axios from 'axios';
import API_BASE_URL from '../Config';

const MallService = {
  getAllMalls: async () => {
    const response = await axios.get(`${API_BASE_URL}/malls`);
    return response.data;
  },

  getMallById: async (mallId) => {
    const response = await axios.get(`${API_BASE_URL}/malls/${mallId}`);
    return response.data;
  },

  createMall: async (mall) => {
    const response = await axios.post(`${API_BASE_URL}/malls`, mall, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  updateMall: async (mallId, mall) => {
    const response = await axios.put(`${API_BASE_URL}/malls/${mallId}`, mall, {
      headers: { 'Content-Type': 'application/json' },
    });
    return response.data;
  },

  deleteMall: async (mallId) => {
    await axios.delete(`${API_BASE_URL}/malls/${mallId}`);
  },

  getShopsByMallId: async (mallId) => {
    const response = await axios.get(`${API_BASE_URL}/malls/${mallId}/shops`);
    return response.data;
  },

  addShopToMall: async (mallId, shop) => {
    const response = await axios.post(`${API_BASE_URL}/malls/${mallId}/shops`, shop);
    return response.data;
  },

  addEmployeeToShop: async (shopId, employee) => {
    const response = await axios.post(`${API_BASE_URL}/shops/${shopId}/employees`, employee);
    return response.data;
  },
};

export default MallService;
