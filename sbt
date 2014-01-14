#!/bin/sh

if test -f ~/.sbtconfig; then
  . ~/.sbtconfig
fi

JAVA_OPTS="$JAVA_OPTS -server -Dfile.encoding=UTF8 -XX:MaxPermSize=512M -Xmx1024M -Xss2M -XX:+CMSClassUnloadingEnabled -XX:+UseConcMarkSweepGC -Djava.net.preferIPv4Stack=true -XX:ReservedCodeCacheSize=192m "

JREBEL_HOME=/opt/jrebel
if [ -d $JREBEL_HOME ]; then
  JAVA_OPTS="$JAVA_OPTS -noverify -javaagent:$JREBEL_HOME/jrebel.jar -Drebel.lift_plugin=true -Drebel.logback_plugin=true"
fi

java $JAVA_OPTS -jar `dirname $0`/sbt-launch-0.12.1.jar "$@"
