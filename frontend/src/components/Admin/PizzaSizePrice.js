import React, { useState } from 'react';
import './Admin.css';

function PizzaSizePrice() {
  const [size, setSize] = useState('');
  const [price, setPrice] = useState('');

  const handleSave = () => {
   
  };

  return (
    <div className="pizza-size-price">
      <h2>Set Pizza Size & Price</h2>
      <input
        type="text"
        placeholder="Size"
        value={size}
        onChange={(e) => setSize(e.target.value)}
      />
      <input
        type="number"
        placeholder="Price"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />
      <button onClick={handleSave}>Save</button>
    </div>
  );
}

export default PizzaSizePrice;
