
// import React, { useState, useEffect } from 'react';
// import MallService from './MallService';
// import './Mall.css';

// const Mall = () => {
//   const [malls, setMalls] = useState([]);
//   const [error, setError] = useState('');
//   const [mallId, setMallId] = useState('');
//   const [mallName, setMallName] = useState('');
//   const [mallLocation, setMallLocation] = useState('');
//   const [isEditing, setIsEditing] = useState(false);
//   const [newShopName, setNewShopName] = useState('');  // For adding a new shop
//   const [newEmployee, setNewEmployee] = useState({ empName: '', empRole: '', empSalary: '' });  // For adding a new employee

//   useEffect(() => {
//     fetchMalls();
//   }, []);

//   const fetchMalls = async () => {
//     try {
//       const data = await MallService.getAllMalls();
//       setMalls(data);
//     } catch (err) {
//       setError('Failed to fetch malls');
//     }
//   };

//   // Clear form for adding or editing mall
//   const clearForm = () => {
//     setMallId('');
//     setMallName('');
//     setMallLocation('');
//     setIsEditing(false);
//   };

//   // Add or update a mall
//   const handleAddMall = async () => {
//     const mallData = { mallId, mallName, mallLocation };
//     try {
//       if (!mallName || !mallLocation || !mallId) {
//         setError('Mall ID, Name, and Location are required');
//         return;
//       }

//       if (isEditing) {
//         await MallService.updateMall(mallId, mallData);
//       } else {
//         await MallService.createMall(mallData);
//       }

//       fetchMalls();
//       clearForm();
//     } catch (err) {
//       setError('Failed to create or update mall');
//     }
//   };

//   // Edit mall
//   const handleEditMall = async (id) => {
//     try {
//       const mall = await MallService.getMallById(id);
//       setMallId(mall.mallId);
//       setMallName(mall.mallName);
//       setMallLocation(mall.mallLocation);
//       setIsEditing(true);
//     } catch (err) {
//       setError('Failed to fetch mall details');
//     }
//   };

//   // Delete mall
//   const handleDeleteMall = async (id) => {
//     try {
//       await MallService.deleteMall(id);
//       fetchMalls();
//     } catch (err) {
//       setError('Failed to delete mall');
//     }
//   };

//   // Add a shop to the mall
//   const handleAddShop = async (mallId) => {
//     if (!newShopName) {
//       setError('Shop name is required');
//       return;
//     }

//     const shopData = { shopName: newShopName };

//     try {
//       await MallService.addShopToMall(mallId, shopData);
//       fetchMalls();  // Refresh the list of malls and their shops
//       setNewShopName('');
//     } catch (err) {
//       setError('Failed to add shop');
//     }
//   };

//   // Add an employee to a specific shop
//   const handleAddEmployee = async (shopId) => {
//     const { empName, empRole, empSalary } = newEmployee;
//     if (!empName || !empRole || !empSalary) {
//       setError('All employee fields are required');
//       return;
//     }

//     const employeeData = { empName, empRole, empSalary };

//     try {
//       await MallService.addEmployeeToShop(shopId, employeeData);
//       fetchMalls();  // Refresh the list of employees in the shop
//       setNewEmployee({ empName: '', empRole: '', empSalary: '' });
//     } catch (err) {
//       setError('Failed to add employee');
//     }
//   };

//   return (
//     <div className="mall-container">
//       <h2>{isEditing ? 'Edit Mall' : 'Add Mall'}</h2>

//       {error && <p className="error-message">{error}</p>}

//       <div className="form-container">
//         <input
//           type="number"
//           placeholder="Mall ID"
//           value={mallId}
//           onChange={(e) => setMallId(e.target.value)}
//           disabled={isEditing}
//         />
//         <input
//           type="text"
//           placeholder="Mall Name"
//           value={mallName}
//           onChange={(e) => setMallName(e.target.value)}
//         />
//         <input
//           type="text"
//           placeholder="Mall Location"
//           value={mallLocation}
//           onChange={(e) => setMallLocation(e.target.value)}
//         />
//         <button onClick={handleAddMall}>
//           {isEditing ? 'Update Mall' : 'Add Mall'}
//         </button>
//       </div>

//       <h3>All Malls</h3>
//       <div className="mall-list">
//         {malls.map((mall) => (
//           <div key={mall.mallId} className="mall-item">
//             <h4>
//               Mall ID: {mall.mallId} <br />
//               Mall Name: {mall.mallName} <br />
//               Mall Location: {mall.mallLocation}
//             </h4>
//             <button onClick={() => handleEditMall(mall.mallId)}>Edit</button>
//             <button onClick={() => handleDeleteMall(mall.mallId)}>Delete</button>

//             {/* Shops and Employees Section */}
//             <h4>Shops in Mall</h4>
//             {mall.shops && mall.shops.map((shop) => (
//               <div key={shop.shopId} className="shop-item">
//                 <p>Shop ID: {shop.shopId}, Shop Name: {shop.shopName}</p>
//                 <h5>Employees in Shop</h5>
//                 {shop.employees && shop.employees.map((emp) => (
//                   <div key={emp.empId} className="employee-item">
//                     <p>Employee ID: {emp.empId}, Name: {emp.empName}, Role: {emp.empRole}, Salary: {emp.empSalary}</p>
//                   </div>
//                 ))}

//                 {/* Add Employee Form for the shop */}
//                 <div className="add-employee-form">
//                   <input
//                     type="text"
//                     placeholder="Employee Name"
//                     value={newEmployee.empName}
//                     onChange={(e) => setNewEmployee({ ...newEmployee, empName: e.target.value })}
//                   />
//                   <input
//                     type="text"
//                     placeholder="Employee Role"
//                     value={newEmployee.empRole}
//                     onChange={(e) => setNewEmployee({ ...newEmployee, empRole: e.target.value })}
//                   />
//                   <input
//                     type="number"
//                     placeholder="Employee Salary"
//                     value={newEmployee.empSalary}
//                     onChange={(e) => setNewEmployee({ ...newEmployee, empSalary: e.target.value })}
//                   />
//                   <button onClick={() => handleAddEmployee(shop.shopId)}>Add Employee</button>
//                 </div>
//               </div>
//             ))}

//             {/* Add Shop Form for the mall */}
//             <div className="add-shop-form">
//               <input
//                 type="text"
//                 placeholder="New Shop Name"
//                 value={newShopName}
//                 onChange={(e) => setNewShopName(e.target.value)}
//               />
//               <button onClick={() => handleAddShop(mall.mallId)}>Add Shop</button>
//             </div>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default Mall;
import React, { useState, useEffect } from 'react';
import MallService from './MallService';
import './Mall.css';

const Mall = () => {
  const [malls, setMalls] = useState([]);
  const [error, setError] = useState('');
  const [mallId, setMallId] = useState('');
  const [mallName, setMallName] = useState('');
  const [mallLocation, setMallLocation] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchMalls();
  }, []);

  const fetchMalls = async () => {
    try {
      const data = await MallService.getAllMalls();
      setMalls(data);
    } catch (err) {
      setError('Failed to fetch malls');
    }
  };

  const clearForm = () => {
    setMallId('');
    setMallName('');
    setMallLocation('');
    setIsEditing(false);
  };

  const handleAddMall = async () => {
    const mallData = { mallId, mallName, mallLocation };
    try {
      if (!mallName || !mallLocation || !mallId) {
        setError('Mall ID, Name, and Location are required');
        return;
      }

      if (isEditing) {
        await MallService.updateMall(mallId, mallData);
      } else {
        await MallService.createMall(mallData);
      }

      fetchMalls();
      clearForm();
    } catch (err) {
      setError('Failed to create or update mall');
    }
  };

  const handleEditMall = async (id) => {
    try {
      const mall = await MallService.getMallById(id);
      setMallId(mall.mallId);
      setMallName(mall.mallName);
      setMallLocation(mall.mallLocation);
      setIsEditing(true);
    } catch (err) {
      setError('Failed to fetch mall details');
    }
  };

  const handleDeleteMall = async (id) => {
    try {
      await MallService.deleteMall(id);
      fetchMalls();
    } catch (err) {
      setError('Failed to delete mall');
    }
  };

  return (
    <div className="mall-container">
      <h2>{isEditing ? 'Edit Mall' : 'Add Mall'}</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="number"
          placeholder="Mall ID"
          value={mallId}
          onChange={(e) => setMallId(e.target.value)}
          disabled={isEditing}
        />
        <input
          type="text"
          placeholder="Mall Name"
          value={mallName}
          onChange={(e) => setMallName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Mall Location"
          value={mallLocation}
          onChange={(e) => setMallLocation(e.target.value)}
        />
        <button onClick={handleAddMall}>
          {isEditing ? 'Update Mall' : 'Add Mall'}
        </button>
      </div>

      <h3>All Malls</h3>
      <div className="mall-list">
        {malls.map((mall) => (
          <div key={mall.mallId} className="mall-item">
            <h4>
              Mall ID: {mall.mallId} <br />
              Mall Name: {mall.mallName} <br />
              Mall Location: {mall.mallLocation}
            </h4>
            <button onClick={() => handleEditMall(mall.mallId)}>Edit</button>
            <button onClick={() => handleDeleteMall(mall.mallId)}>Delete</button>

            {/* Shops and Employees Section */}
            <h4>Shops in Mall</h4>
            {mall.shops && mall.shops.length > 0 ? (
              mall.shops.map((shop) => (
                <div key={shop.shopId} className="shop-item">
                  <p>Shop ID: {shop.shopId}, Shop Name: {shop.shopName}, Shop Owner: {shop.shopOwner}</p>
                  <h5>Employees in Shop</h5>
                  {shop.employees && shop.employees.length > 0 ? (
                    shop.employees.map((emp) => (
                      <div key={emp.empId} className="employee-item">
                        <p>Employee ID: {emp.empId}, Name: {emp.empName}, Role: {emp.empRole}, Salary: {emp.empSalary}</p>
                      </div>
                    ))
                  ) : (
                    <p>No employees available.</p>
                  )}
                </div>
              ))
            ) : (
              <p>No shops available.</p>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Mall;
