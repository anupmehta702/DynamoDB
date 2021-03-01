
**DynamoDB project to test connectivity**
<br />*_Reference https://docs.aws.amazon.com/streams/latest/dev/tutorial-stock-data-kplkcl.html _*


**How to add existing project in git repo**
<br />git init 
<br />git add .
<br />git commit -m "My first commit"
<br />git remote add origin remote <repo URL>
<br />git remote -v
<br />git push -f origin main ( and not master) 

<b> If you have added code to master,do below steps to merge master branch to main</b>
<br />git checkout master  
<br />git branch main master -f    
<br />git checkout main  
<br />git push origin main -f 
