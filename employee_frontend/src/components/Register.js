import { useState } from "react";
import axios from "axios";

function Register() {
  const [employeename, setEmployeename] = useState("");
  const [employeerole, setEmployeerole] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function save(event) {
    alert(employeename);
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/register",
        {
          username: employeename,
          role: employeerole,
          email: email,
          password: password,
        }
      );
      alert(response.email);
    } catch (err) {
      alert(err);
    }
  }

  return (
    <div>
      <div class="container mt-4">
        <div class="card">
          <h1>Student Registation</h1>

          <form>
            <div class="form-group">
              <label>Employee name</label>
              <input
                type="text"
                class="form-control"
                id="employeename"
                placeholder="Enter Name"
                value={employeename}
                onChange={(event) => {
                  setEmployeename(event.target.value);
                }}
              />
            </div>
            <div class="form-group">
              <label>Employee Role</label>
              <input
                type="text"
                class="form-control"
                id="employeerole"
                placeholder="Enter Role"
                value={employeerole}
                onChange={(event) => {
                  setEmployeerole(event.target.value);
                }}
              />
            </div>

            <div class="form-group">
              <label>email</label>
              <input
                type="email"
                class="form-control"
                id="email"
                placeholder="Enter Email"
                value={email}
                onChange={(event) => {
                  setEmail(event.target.value);
                }}
              />
            </div>

            <div class="form-group">
              <label>password</label>
              <input
                type="password"
                class="form-control"
                id="password"
                placeholder="Enter password"
                value={password}
                onChange={(event) => {
                  setPassword(event.target.value);
                }}
              />
            </div>

            <button type="submit" class="btn btn-primary mt-4" onClick={save}>
              Save
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;
