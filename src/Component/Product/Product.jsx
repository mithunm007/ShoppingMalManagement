import React, { useState, useEffect } from 'react';
import ProductService from './ProductService';
import './Product.css';

const Product = () => {
  const [products, setProducts] = useState([]);
  const [pId, setPId] = useState('');
  const [category, setCategory] = useState('');
  const [price, setPrice] = useState('');
  const [productName, setProductName] = useState('');
  const [mallId, setMallId] = useState('');
  const [shopId, setShopId] = useState('');
  const [error, setError] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const data = await ProductService.getAllProducts();
      setProducts(data);
    } catch (err) {
      setError('Failed to fetch products');
    }
  };

  const handleAddProduct = async () => {
    const productData = { 
      pId, 
      category, 
      price, 
      productName, 
      mallId, 
      shopId 
    };

    try {
      if (!pId || !category || !price || !productName || !mallId || !shopId) {
        setError('All fields are required');
        return;
      }

      if (isEditing) {
        await ProductService.updateProduct(pId, productData);
      } else {
        await ProductService.createProduct(productData);
      }

      fetchProducts();
      clearForm();
    } catch (err) {
      setError('Failed to create or update product');
    }
  };

  const handleEditProduct = async (id) => {
    try {
      const product = await ProductService.getProductById(id);
      setPId(product.pId);
      setCategory(product.category);
      setPrice(product.price);
      setProductName(product.productName);
      setMallId(product.mallId);
      setShopId(product.shopId);
      setIsEditing(true);
    } catch (err) {
      setError('Failed to fetch product details');
    }
  };

  const handleDeleteProduct = async (id) => {
    try {
      await ProductService.deleteProduct(id);
      fetchProducts();
    } catch (err) {
      setError('Failed to delete product');
    }
  };

  const clearForm = () => {
    setPId('');
    setCategory('');
    setPrice('');
    setProductName('');
    setMallId('');
    setShopId('');
    setIsEditing(false);
  };

  return (
    <div className="product-container">
      <h2>{isEditing ? 'Edit Product' : 'Add Product'}</h2>

      {error && <p className="error-message">{error}</p>}

      <div className="form-container">
        <input
          type="text"
          placeholder="Product ID"
          value={pId}
          onChange={(e) => setPId(e.target.value)}
          disabled={isEditing}
        />
        <input
          type="text"
          placeholder="Category"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
        />
        <input
          type="text"
          placeholder="Price"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <input
          type="text"
          placeholder="Product Name"
          value={productName}
          onChange={(e) => setProductName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Mall ID"
          value={mallId}
          onChange={(e) => setMallId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Shop ID"
          value={shopId}
          onChange={(e) => setShopId(e.target.value)}
        />
        <button onClick={handleAddProduct}>
          {isEditing ? 'Update Product' : 'Add Product'}
        </button>
      </div>

      <h3>All Products</h3>
      <div className="product-list">
        {products.map((product) => (
          <div key={product.pId} className="product-item">
            <h4>
              Product ID: {product.pId} <br />
              Category: {product.category} <br />
              Price: {product.price} <br />
              Product Name: {product.productName} <br />
            </h4>
            <button onClick={() => handleEditProduct(product.pId)}>Edit</button>
            <button onClick={() => handleDeleteProduct(product.pId)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Product;
