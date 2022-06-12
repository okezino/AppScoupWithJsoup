# TRUE_CALLER ASSIGNMENT



## About
This android application involves getting the content of a true caller blog and manipulating with the text content and display three distinct  pattern of
the data

### Blog Url :  
https://blog.truecaller.com/2018/01/22/life-as-an-android-engineer/


### 1. True caller10thCharacterRequest:
Find the 10th character and display it on the screen
### 2. True callerEvery10thCharacterRequest:
Find every 10th character (i.e. 10th, 20th, 30th, etc.) and display the array on the screen
### 3. True caller WordCounterRequest:
   Split the text into words using whitespace characters (i.e. space, tab, line break, etc.),
   count the occurrence of every unique word (case insensitive) and display the count for each
   word on the screen


## Libraries and Technology 

### Programming Language 
-Kotlin 

### Network Call
- Jsoup : For making my Api call and getting the web content, Jsoup is used to the web content as a document, after which further manipulation is done 

## Dependency Injection
- Dagger Hilt - This is use to inject object of class in the View_model, Repository and UseCase

## Reactive Programming 
-LiveData : This was used to Update the View as a listener 

### Testing
- Mockito : For mocking instance of Object
- espresso : For making UI test
 - Truth : For making test assumption more readable 
  
### MultiThreading
-Coroutines : Coroutines was used to manipulate thread, moving from main to worker thread and vise versa

## Navigation 
- Nav Component : Not very much of this library was used, but it was used to hold the HomeFragment on the Main Activity 

## Architecture 
-Clean Architecture : Clean Code and Clean architectural model was follow

## BUILD PATH 
okeh_joseph\app\build\outputs\apk\debug

## Screenshots
![Screenshot_1654947529](https://user-images.githubusercontent.com/46386915/173186845-44675830-ae59-421c-b33c-318b932f2d34.png)
![Screenshot_1654947561](https://user-images.githubusercontent.com/46386915/173186951-044cf0e0-3bf6-4956-b190-05cb688fedd2.png)


### Assumption 
I assume the Content of the Blog Post starts from the First Paragraph which is this below and i included the tags for every tags when converting as stated on the task 
```
Have you ever wondered how it is to be an Android Developer that works on an app with over 
250 Million users? We had the opportunity to borrow, Mike, for a conversion about his job 
as an Android Developer, and what kind of mindset one needs to possess to get to where he is today.

```

