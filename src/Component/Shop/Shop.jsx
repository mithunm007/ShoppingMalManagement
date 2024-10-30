import React, { useState, useEffect } from 'react';
import ShopService from './ShopService';
import './Shop.css';

const Shop = () => {
  const [shops, setShops] = useState([]);
  const [shopId, setShopId] = useState('');
  const [shopName, setShopName] = useState('');
  const [shopOwner, setShopOwner] = useState('');
  const [employees, setEmployees] = useState([]);
  const [error, setError] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchShops();
  }, []);

  const fetchShops = async () => {
    try {
      const data = await ShopService.getAllShops();
      setShops(data);
    } catch (err) {
      setError('Failed to fetch shops');
    }
  };

  const handleAddShop = async () => {
    const shopData = { shopId, shopName, shopOwner };

    try {
      if (!shopId || !shopName || !shopOwner) {
        setError('Shop ID, Name, and Owner are required');
        return;
      }

      if (isEditing) {
        await ShopService.updateShop(shopId, shopData);
      } else {
        await ShopService.createShop(shopData);
      }

      fetchShops();
      clearForm();
    } catch (err) {
      setError('Failed to create or update shop');
    }
  };

  const handleEditShop = async (id) => {
    try {
      const shop = await ShopService.getShopById(id);
      setShopId(shop.shopId);
      setShopName(shop.shopName);
      setShopOwner(shop.shopOwner);
      setEmployees(shop.employees);  // Assuming shop includes employee list
      setIsEditing(true);
    } catch (err) {
      setError('Failed to fetch shop details');
    }
  };

  const handleDeleteShop = async (id) => {
    try {
      await ShopService.deleteShop(id);
      fetchShops();
    } catch (err) {
      setError('Failed to delete shop');
    }
  };

  const clearForm = () => {
    setShopId('');
    setShopName('');
    setShopOwner('');
    setEmployees([]);
    setIsEditing(false);
  };

  return (
    
    <div className="shop-container">
      <h2>{isEditing ? 'Edit Shop' : ' Shop management'}</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Shop ID"
          value={shopId}
          onChange={(e) => setShopId(e.target.value)}
          disabled={isEditing} // Disable editing of shopId when in update mode
        />
        <input
          type="text"
          placeholder="Shop Name"
          value={shopName}
          onChange={(e) => setShopName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Shop Owner"
          value={shopOwner}
          onChange={(e) => setShopOwner(e.target.value)}
        />
        <button onClick={handleAddShop}>
          {isEditing ? 'Update Shop' : 'Add Shop'}
        </button>
      </div>

      <h3>All Shops</h3>
      <div className="shop-list">
        {shops.map((shop) => (
          <div key={shop.shopId} className="shop-item">
            <h4>
              Shop ID: {shop.shopId} <br />
              Name: {shop.shopName} <br />
              Owner: {shop.shopOwner}
            </h4>

            <h5>Employees:</h5>
            {shop.employees && shop.employees.length > 0 ? (
              <ul>
                {shop.employees.map((emp) => (
                  <li key={emp.empId}>
                    <div>ID: {emp.empId}</div>
                    <div>Name: {emp.empName}</div>
                    <div>Role: {emp.empRole}</div>
                    <div>Salary: {emp.empSalary}</div>
                  </li>
                ))}
              </ul>
            ) : (
              <p>No employees assigned to this shop</p>
            )}

            <button onClick={() => handleEditShop(shop.shopId)}>Edit</button>
            <button onClick={() => handleDeleteShop(shop.shopId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Shop;

