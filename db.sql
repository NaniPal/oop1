-- Categories
CREATE TABLE Categories (
  category_id INT PRIMARY KEY,
  name VARCHAR(255)
);

-- Books
CREATE TABLE Books (
  book_id INT PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  publication_year INT,
  price DECIMAL(10, 2),
  quantity_available INT,
  category_id INT,
  FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Users 
CREATE TABLE Users (
  user_id INT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(255),
  phone_number VARCHAR(20)
);

-- Orders
CREATE TABLE Orders (
  order_id INT PRIMARY KEY,
  user_id INT,
  order_date DATE,
  total_amount DECIMAL(10, 2),
  status VARCHAR(50),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Order_Items
CREATE TABLE Order_Items (
  order_item_id INT PRIMARY KEY,
  order_id INT,
  book_id INT,
  quantity INT,
  price_per_unit DECIMAL(10, 2),
  FOREIGN KEY (order_id) REFERENCES Orders(order_id),
  FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- Reviews
CREATE TABLE Reviews (
  review_id INT PRIMARY KEY,
  book_id INT,
  user_id INT,
  rating INT,
  comment TEXT,
  review_date DATE,
  FOREIGN KEY (book_id) REFERENCES Books(book_id),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Wishlist
CREATE TABLE Wishlist (
  wishlist_id INT PRIMARY KEY,
  user_id INT,
  book_id INT,
  FOREIGN KEY (user_id) REFERENCES Users(user_id),
  FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- Examples
INSERT INTO Categories (category_id, name)
VALUES (1, 'Fiction');

INSERT INTO Categories (category_id, name)
VALUES (2, 'Mystery');

INSERT INTO Books (book_id, title, author, publication_year, price, quantity_available, category_id)
VALUES (1, 'To Kill a Mockingbird', 'Harper Lee', 1960, 12.99, 10, 1);

INSERT INTO Books (book_id, title, author, publication_year, price, quantity_available, category_id)
VALUES (2, 'The Da Vinci Code', 'Dan Brown', 2003, 9.99, 15, 2);

INSERT INTO Users (user_id, username, password, email, first_name, last_name, address, phone_number)
VALUES (1, 'johnsmith', 'password', 'john@example.com', 'John', 'Smith', '123 Main St', '123123123');

INSERT INTO Users (user_id, username, password, email, first_name, last_name, address, phone_number)
VALUES (2, 'jane.doe', 'pass123', 'jane@example.com', 'Jane', 'Doe', '456 Elm St', '123123123');

INSERT INTO Orders (order_id, user_id, order_date, total_amount, status)
VALUES (1, 1, '2023-07-01', 29.99, 'Pending');

INSERT INTO Orders (order_id, user_id, order_date, total_amount, status)
VALUES (2, 2, '2023-07-02', 45.99, 'Shipped');

INSERT INTO Order_Items (order_item_id, order_id, book_id, quantity, price_per_unit)
VALUES (1, 1, 1, 2, 12.99);

INSERT INTO Order_Items (order_item_id, order_id, book_id, quantity, price_per_unit)
VALUES (2, 1, 2, 1, 9.99);

INSERT INTO Reviews (review_id, book_id, user_id, rating, comment, review_date)
VALUES (1, 1, 1, 5, 'Great book!', '2023-07-05');

INSERT INTO Reviews (review_id, book_id, user_id, rating, comment, review_date)
VALUES (2, 2, 2, 4, 'Interesting read.', '2023-07-06');

INSERT INTO Wishlist (wishlist_id, user_id, book_id)
VALUES (1, 1, 2);

INSERT INTO Wishlist (wishlist_id, user_id, book_id)
VALUES (2, 2, 1);







