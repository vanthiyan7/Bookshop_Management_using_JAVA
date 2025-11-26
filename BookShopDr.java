import java.io.*;
import java.util.*;
class IncorrectInputException extends Exception
{
String m;
IncorrectInputException(String m)
{
super(m);
this.m = m;
}
public String toString()
{
return "IncorrectInputException - "+m;
}
}

class Book
{
String title,author,publisher;
double price;
int stock;

Book()
{
title =  null;
author = null;
publisher = null;
price =0.0;
stock = 0;
}

Book(String title,String author,String publisher,double price,int stock)
{
this.title = title;
this.author = author;
this.publisher = publisher;
this.price = price;
this.stock = stock;
}

public String toString()
{
return "Title :"+title+"\nAuthor :"+author+"\nPublisher :"+publisher+"\nPrice :"+price+"\nStock :"+stock;
}
}

class BookShop
{
List<Book> l = new ArrayList<>(); 
boolean addBook(Book k)
{
if(search(k.title,k.author) == true)
for(int i=0;i<l.size();i++)
{
Book m =l.get(i);
if(k.title.equalsIgnoreCase(m.title) && k.author.equalsIgnoreCase(m.author))
{
m.stock +=k.stock;
l.set(i,m);
}
return true;
}
else

return l.add(k);
return true;
} 

boolean search(String title, String author)
{
for(Book k : l)
if(title.equalsIgnoreCase(k.title) && author.equalsIgnoreCase(k.author))
return true;
return false;
}

void purchase(String title, String author,int nc) throws IncorrectInputException
{
if(nc < 0)
throw new IncorrectInputException("Number of copies cannot be negative");

else
{
if(search(title,author) == true)
{
for(int i=0;i<l.size();i++)
{
Book m=l.get(i);
if(title.equalsIgnoreCase(m.title) && author.equalsIgnoreCase(m.author))
{
if(m.stock >= nc)
{
m.stock-=nc;
l.set(i,m);
System.out.println(m);
System.out.println("Total Cost: "+(m.price* nc));
}
else
throw new IncorrectInputException("Required copies not in stock");
}
}
}
else
throw new IncorrectInputException("Book not available"); 

}
}

public String toString()
{
String s =" ";
for(Book k : l)
s =s+k+"\n";
return s;
}
}
class BookShopDriver
{
public static void main(String arg[]) throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int ch; 
String s;
BookShop bs =new BookShop();
System.out.println("Simren BookShop");

do
{
System.out.println("Add Books-----1");
System.out.println("Search books-----2");
System.out.println("Purchase books----3");
System.out.println("Display books-----4");
System.out.println("Exit-------------5");
System.out.println("Enter your choice:");
ch=Integer.parseInt(br.readLine());

switch(ch)
{
case 1:
System.out.println("Enter title, author, publisher price and stock of book:");
Book k=new Book(br.readLine(),br.readLine(),br.readLine(), Double.parseDouble(br.readLine()), Integer.parseInt(br.readLine()));
bs.addBook (k);
break;
case 2:
System.out.println("Enter title and author of book:");
System.out.println("Is the book available:"+bs.search(br.readLine(),br.readLine()));
break;
case 3:
try
{
System.out.println("Enter title and author of book and required no of copies:");
bs.purchase(br.readLine(),br.readLine(), Integer.parseInt(br.readLine()));
break;
}catch (IncorrectInputException ie)
{
System.out.println(ie.getMessage());
}
catch (NumberFormatException ne)
{
System.out.println("Invalid input. Please try again");
}
case 4:
System.out.println(bs);
break;
case 5:
break;
default:
System.out.println("Invalid choice");
}
}while(ch !=5);
}
}


