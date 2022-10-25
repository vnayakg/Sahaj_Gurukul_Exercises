Exercise 1: Git Commands Learned from Katas

1. Basic Commits:
- git add
- git commit
- git commit -m "My commit message"
- git log
- git log -n 5
- git log --oneline
- git log --oneline --graph


2. Basic Staging:
- git restore --staged


3. Investigation:
- git ls-tree -> eg. git ls-tree master .
- git cat-file -> git cat file -p <hash>
- -p -> for objects content
- -t -> show object type

  
4. Basic Branching:
- git switch
- git switch -c
- git branch
- git diff

  
5. Fast forward merge:
- git branch -d <branch-name>
- git merge <branch>
- git diff <branchA> <branchB>

  
6. 3-way merge
- git merge <branchA> <branchB>
- git diff <branchA> <branchB>
