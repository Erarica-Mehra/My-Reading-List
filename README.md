<h2>Introduction</h2>
<p>I created this project in 2017 to experiment with REST APIs. While I was learning to use and create Rest Apis, I decided to merge my two interests, books and code.</br>
This project uses GoodReads API to generate my personal reading list and pick my next read.
</p>

<h3>GoodReads API </h3>
<p>The Goodreads API allows developers to access Goodreads data in order to help applications that deal with books.
You can learn more about GoodReads by visiting this link. <link>https://www.goodreads.com/api/index</link>

<h3>Getting Started</h3>
<ol>
  <li>Clone this project and import into your IDE.</li>
  <li>To access GoodReads API to need to create a developer account. Once you do that, you will be provided with a secret key. Replace the string "SECRET_KEY" in RestClientService with your secret key</li>
  <li>To connect with mysql, refer application.properties. The DB folder contains queries you need to run the project. Create a database and exceute the queries.</li>
  <li>Now you are good to go.</li>
  </ol>
  
  <h3>Overview</h3>
  <p>The Goodreads API supports only XML format. I have used JAXB API to convert XML into Java objects. This process is call unmarshalling.
  The scope of this project includes: 
  <ol>
    <li>Search the Goodreads inventory on the basis of book title or author name</li>
    <li>Add books to your personal reading list</li>
    <li>Pick you next read - Confused about which book to read. This happens a lot with me when I have all awesome books to read and choose one above others. This feature randomly selects a book from your reading list for your next read.</li>
    </ol>
    
<h3>Built With</h3>
<ol>
  <li>Java</li>
  <li>MySQL</li>
  </ol>
    
<h3>Author</h3>
<p>Erarica Mehra</p>
