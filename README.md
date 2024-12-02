# E-commerce Project

## Project Overview

**Tên dự án**: Hệ thống Thương mại Điện tử (E-commerce)

### Mục tiêu:
- Xây dựng một hệ thống thương mại điện tử cho phép người dùng có thể mua sắm online.
- Cung cấp các chức năng như giỏ hàng, thanh toán, theo dõi đơn hàng, quản lý sản phẩm và người dùng.

### Các tính năng chính:
1. **Quản lý giỏ hàng**:
   - Người dùng có thể thêm, sửa, và xóa sản phẩm trong giỏ hàng.
   - Hệ thống tính toán tổng giá trị giỏ hàng dựa trên số lượng và giá của từng sản phẩm.
   
2. **Quản lý đơn hàng**:
   - Người dùng có thể đặt hàng từ giỏ hàng của mình.
   - Hệ thống theo dõi tình trạng đơn hàng (đã thanh toán, đang giao, đã giao, v.v.).
   
3. **Quản lý người dùng**:
   - Người dùng có thể đăng ký và đăng nhập vào hệ thống.
   - Quản lý thông tin người dùng như tên, email, mật khẩu và vai trò (admin hoặc khách hàng).
   
4. **Quản lý sản phẩm**:
   - Các quản trị viên có thể thêm, sửa, và xóa sản phẩm.
   - Mỗi sản phẩm bao gồm các thông tin như tên, mô tả, giá, và số lượng trong kho.
   
5. **Thanh toán và vận chuyển**:
   - Hệ thống hỗ trợ các phương thức thanh toán (ví dụ: qua các dịch vụ như MoMo, ZaloPay).
   - Hệ thống cung cấp thông tin trạng thái giao hàng.

## Công nghệ sử dụng

1. **Frontend**:
   - **React.js**:
     - Xây dựng giao diện người dùng, tạo các trang giỏ hàng, thanh toán, đăng nhập, và quản lý sản phẩm.

2. **Backend**:
   - **Spring Boot**:
     - Framework chính để xây dựng các API RESTful cho hệ thống.
   
3. **Database**:
   - **MySQL**:
     - Quản lý dữ liệu của người dùng, giỏ hàng, sản phẩm và đơn hàng.

4. **Security**:
   - **Spring Security**:
     - Bảo mật hệ thống, hỗ trợ xác thực người dùng và phân quyền truy cập.

5. **Payment Integration**:
   - **MoMo Payment Gateway, ZaloPay**:
     - Tích hợp các dịch vụ thanh toán trực tuyến.

6. **API Testing**:
   - **JUnit, Mockito**:
     - Viết kiểm tra đơn vị cho các dịch vụ và repository trong Spring Boot.

7. **Build & Dependency Management**:
   - **Maven**:
     - Quản lý thư viện và phụ thuộc của dự án.

8. **Version Control**:
   - **Git**:
     - Quản lý mã nguồn với GitHub hoặc GitLab.

9. **Deployment**:
   - **Docker**:
     - Đóng gói ứng dụng vào các container và triển khai hệ thống.

10. **Other Tools**:
    - **Postman**: Kiểm thử API.
    - **Swagger**: Tạo tài liệu API tự động.

## Quy trình phát triển

1. **Phân tích yêu cầu**:
   - Xác định các tính năng của hệ thống, bảo mật, hiệu suất và khả năng mở rộng.

2. **Thiết kế hệ thống**:
   - Lập sơ đồ UML, thiết kế các API, cơ sở dữ liệu và giao diện người dùng.

3. **Phát triển ứng dụng**:
   - Xây dựng các tính năng chính như giỏ hàng, đơn hàng, thanh toán và quản lý người dùng.

4. **Kiểm thử**:
   - Kiểm thử hệ thống với các bài kiểm tra đơn vị và tích hợp.

5. **Triển khai**:
   - Triển khai ứng dụng trên môi trường sản xuất, sử dụng Docker.

6. **Bảo trì và mở rộng**:
   - Bảo trì hệ thống và thêm các tính năng mới theo phản hồi người dùng.

## Hướng dẫn cài đặt và sử dụng

### 1. Clone repository:
```bash
git clone https://github.com/tain03/ecommerce.git
cd ecommerce
