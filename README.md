# MultithreadSorter
Viết chương trình sắp xếp 1 dãy số nguyên theo thứ tự tăng dần và ghi 
kết quả ra 1 file text có tên là output.txt, với các yêu cầu:
Dãy số nguyên đầu vào được cho trong 1 file text có tên là input.txt, mỗi số 
nguyên phân cách nhau bởi kí tự backspace hoặc kí tự xuống dòng.
Chương trình sử dụng n thread để sắp xếp đồng thời dãy số nguyên đó (vì số lượng 
phần tử của dãy số nguyên có thể là rất lớn, sử dụng multithreading để tối ưu tốc 
độ trên các CPU hỗ trợ xử lý multithreading), n sẽ được đưa vào trong tham số 
dòng lệnh.
Gợi ý giải thuật: Chia dãy số input thành n dãy con, mỗi dãy con sau đó sẽ được 
sắp xếp bởi 1 thread tương ứng. Sau khi n thread đã sắp xếp xong n dãy con ta thu 
được n dãy con đã có thứ tự, khi đó ta sẽ dễ dàng trộn n dãy con đó thành 1 dãy 
hoàn chỉnh có thứ tự tăng dần.
*Lưu ý:
- Các tham số cấu hình phải để ngoài file config, có thể cấu hình lại được (ko fix 
code).
- Lập tài liệu statistic, benchmark: khi sử dụng các tham số test khác nhau (ví dụ 
config 1 thread, 2 thread, 4 thread …, dữ liệu 1M, 2M, 10M …)
