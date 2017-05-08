## EmailService

Management wants to do email campains to specific groups of persons in our dataSource.
(You don't need to send real mail just create instances of the Email class)

MVP1: 
- It should be possible to send mails to persons with a certain hobby
- They should be able to pass a mail body with placeholders for firstName, lastName and hobby
- The placeholder should be replaced with the correct fields


MVP2:
They also want to be abble to send mails:
- LastName (ingore case)
- FirstName (ignore case)
- FuzzyNameSearch => the firstname or lastname contains this piece of text (ignoring case)


MVP3:
- Make it possible to dynamicly pass the existing filter criteria.
    - match all passed criteria
    - match any of the passed criteria


change request:
The email server has problems handeling all these individual mails so management came with a solutions.
Can't we send group emails to all people with the same firstName because the lastName placeholder is never used anyway.
This way our server will have less load

tasks:
- create a group mail function that takes criteria from MVP3
- validate that te lastName placeholder isn't used in the body of the mail
- Send a groupMail to the users based on firstName


Extra don't forget your tests.