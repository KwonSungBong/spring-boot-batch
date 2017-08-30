#! /bin/bash
cd /home/whilemouse/git/spring-boot-batch
#git --git-dir=/home/whilemouse/git/spring-boot-batch/.git reset --hard
#git --git-dir=/home/whilemouse/git/spring-boot-batch/.git pull
#cd /home/whilemouse/git/spring-boot-batch
git reset --hard
git pull
gradle clean
gradle build

