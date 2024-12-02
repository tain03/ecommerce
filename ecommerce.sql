INSERT INTO categories (name)
VALUES
('Books'),
('Clothes'),
('Electronics'),
('Home Appliances'),
('Shoes'),
('Laptops');

INSERT INTO products (name, description, price, category_id, image_url)
VALUES
('The Great Gatsby', 'A classic novel by F. Scott Fitzgerald', 10.99, 1, '/images/books.jpg'),
('Samsung Galaxy S21', 'Latest Samsung smartphone with 5G', 799.99, 3, '/images/mobile.jpg'),
('Nike Air Max', 'Comfortable running shoes for everyday use', 119.99, 5, '/images/shoes.jpg'),
('MacBook Pro 16"', 'Powerful laptop for professionals', 2399.99, 6, '/images/laptops.jpg'),
('Blender', 'High-powered blender for smoothies', 89.99, 4, '/images/blender.jpg');

INSERT INTO products (name, description, price, category_id, image_url)
VALUES
('Moby Dick', 'A novel by Herman Melville', 12.99, 1, '/images/books.jpg'),
('1984', 'A dystopian novel by George Orwell', 9.99, 1, '/images/books.jpg'),
('iPhone 13', 'Apple smartphone with A15 chip', 999.99, 3, '/images/mobile.jpg'),
('Google Pixel 6', 'Smartphone by Google with a powerful camera', 699.99, 3, '/images/mobile.jpg'),
('Adidas Ultraboost', 'High-performance running shoes', 150.00, 5, '/images/shoes.jpg'),
('Puma Suede', 'Stylish and comfortable sneakers', 85.00, 5, '/images/shoes.jpg'),
('Dell XPS 13', 'Compact and powerful laptop', 1499.99, 6, '/images/laptops.jpg'),
('HP Spectre x360', 'Convertible laptop with Intel i7 processor', 1799.99, 6, '/images/laptops.jpg'),
('Dell 27" Monitor', 'High-definition monitor for work and gaming', 299.99, 4, '/images/monitors.jpg'),
('Samsung 32" Curved Monitor', 'Curved screen for immersive viewing experience', 379.99, 4, '/images/monitors.jpg'),
('Sony PlayStation 5', 'Next-generation gaming console from Sony', 499.99, 4, '/images/electronics.jpg'),
('Air Purifier', 'Clean the air in your home or office', 129.99, 4, '/images/electronics.jpg'),
('Canon EOS R5', 'Mirrorless digital camera with 8K video recording', 3899.99, 4, '/images/camera.jpg'),
('Fujifilm X-T4', 'Mirrorless camera with advanced features', 1699.99, 4, '/images/camera.jpg'),
('GoPro Hero 10', 'Action camera for capturing adventures', 399.99, 4, '/images/electronics.jpg'),
('Samsung 55" Smart TV', '4K Smart TV with HDR support', 799.99, 4, '/images/tv.jpg'),
('Sony WH-1000XM4', 'Noise-cancelling headphones by Sony', 349.99, 4, '/images/headphones.jpg'),
('Bose QuietComfort 35', 'Wireless headphones with noise-cancelling', 299.99, 4, '/images/headphones.jpg'),
('Razer Blade 15', 'Gaming laptop with powerful graphics', 1899.99, 6, '/images/laptops.jpg'),
('Microsoft Surface Laptop 4', 'Laptop with high performance and a great display', 1299.99, 6, '/images/laptops.jpg'),
('Asus ZenBook 14', 'Thin and light laptop with excellent battery life', 1099.99, 6, '/images/laptops.jpg'),
('Bose SoundLink Revolve', 'Portable Bluetooth speaker with 360° sound', 229.99, 4, '/images/speaker.jpg'),
('JBL Flip 5', 'Portable waterproof Bluetooth speaker', 119.99, 4, '/images/speaker.jpg'),
('Apple AirPods Pro', 'True wireless earbuds with active noise cancellation', 249.99, 4, '/images/airpods.jpg'),
('Samsung Galaxy Tab S7', 'Premium Android tablet with 120Hz display', 649.99, 4, '/images/tablet.jpg'),
('Apple iPad Pro 11"', '11-inch iPad with Apple M1 chip', 799.99, 4, '/images/ipad.jpg'),
('Microsoft Xbox Series X', 'Gaming console with 4K resolution', 499.99, 4, '/images/electronics.jpg');


INSERT INTO users (username, password, email, role)
VALUES
('admin', 'password_hashed', 'admin@example.com', 'ADMIN'),
('john_doe', 'password_hashed', 'john_doe@example.com', 'CUSTOMER'),
('jane_doe', 'password_hashed', 'jane_doe@example.com', 'CUSTOMER');

INSERT INTO carts (user_id)
VALUES
(1),  -- Admin's cart
(2),  -- John Doe's cart
(3);  -- Jane Doe's cart

INSERT INTO cart_items (cart_id, product_id, quantity)
VALUES
(1, 1, 1),  -- Admin adds 1 copy of The Great Gatsby to the cart
(2, 2, 2),  -- John adds 2 Samsung Galaxy S21 to the cart
(3, 5, 1);  -- Jane adds 1 Blender to the cart

INSERT INTO orders (user_id, order_date, status)
VALUES
(1, '2024-12-01', 'COMPLETED'),
(2, '2024-12-02', 'PENDING'),
(3, '2024-12-03', 'COMPLETED');

INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES
(1, 1, 1, 10.99),  -- Admin's order: 1 copy of The Great Gatsby
(2, 2, 2, 799.99),  -- John's order: 2 Samsung Galaxy S21
(3, 5, 1, 89.99);  -- Jane's order: 1 Blender

