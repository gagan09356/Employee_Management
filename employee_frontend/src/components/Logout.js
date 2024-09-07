import React from "react";
import axios from "axios";

const Logout = () => {
  const handleLogout = async () => {
    try {
      const response = await axios.post("/api/auth/logout");
      alert(response.data);
    } catch (error) {
      alert("Logout failed");
    }
  };

  return <button onClick={handleLogout}>Logout</button>;
};

export default Logout;
