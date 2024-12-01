CREATE DATABASE TaskManagement;

USE TaskManagement;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role ENUM('Admin', 'Staff', 'Customer') NOT NULL
);

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status ENUM('Pending', 'In Progress', 'Completed') DEFAULT 'Pending',
    assigned_to INT,
    created_by INT,
    FOREIGN KEY (assigned_to) REFERENCES users(id),
    FOREIGN KEY (created_by) REFERENCES users(id)
);

INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'Admin');
INSERT INTO users (username, password, role) VALUES ('staff', 'staff123', 'Staff');
INSERT INTO users (username, password, role) VALUES ('customer', 'customer123', 'Customer');
