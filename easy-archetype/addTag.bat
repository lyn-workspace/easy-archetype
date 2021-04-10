
@echo off
echo show tag version %1%
set /p msg=tag version:
git status && git pull && echo 'git pull success'
git add .
echo  commit message:   "addTag"
git commit -m "addTag"
echo start addTag
git tag "tag-%msg%" && git push --tag &&  git push && echo "git push success..."


