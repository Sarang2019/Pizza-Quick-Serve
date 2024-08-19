import React, { useState, useEffect } from 'react';
import '../../styles/Admin.css';

function EditPizza({ match }) {
  const [pizza, setPizza] = useState({ name: '', size: '', price: '' });

  useEffect(() => {
    // Fetch pizza data by ID and set it to state
  }, [match.params.id]);

  const handleEditPizza = () => {
   
  };

  return (
    <div className="edit-pizza">
      <h2>Edit Pizza</h2>
      <input
        type="text"
        placeholder="Pizza Name"
        value={pizza.name}
        onChange={(e) => setPizza({ ...pizza, name: e.target.value })}
      />
      <input
        type="text"
        placeholder="Size"
        value={pizza.size}
        onChange={(e) => setPizza({ ...pizza, size: e.target.value })}
      />
      <input
        type="number"
        placeholder="Price"
        value={pizza.price}
        onChange={(e) => setPizza({ ...pizza, price: e.target.value })}
      />
      <button onClick={handleEditPizza}>Save Changes</button>
    </div>
  );
}

export default EditPizza;
