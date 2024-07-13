# Library-management-system

This application is for managing the library

1.Add books to library

- This api is used for add books in library 

curl --location 'http://localhost:8080/library/addBook' \
--header 'Content-Type: application/json' \
--data '{
"isbn": "978-0132350889",
"title": "Clean Code",
"author": "Robert C. Martin",
"genre": "Software Engineering",
"publicationYear": 2008,
"department": "Computer Science and Engineering",
"available": true
}'

2.find books by title

- This api is used for finding book by title

curl --location 'http://localhost:8080/library/findBooksByTitle/Refactoring: Improving the Design of Existing Code' \
--header 'Content-Type: application/json'

3.Delete book by ISBN code

- This api is used for deleting books in library

http://localhost:8080/removeBook/978-0201485677

4.find book by author

- This api is used for getting the book details by author

http://localhost:8080/findBooksByAuthor/author/Robert C. Martin

5.Get all books in library

- USe this API to get all the books in library

http://localhost:8080/library/listAllBooks

6.Get All the available books in library

-This api is used to get the all the available books in library

http://localhost:8080/library/listAvailableBooks
