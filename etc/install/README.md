# WARP 10 Install - Standalone version

## Download Standalone binary

Standalone binary is available via bintray: https://bintray.com/cityzendata/generic/warp10/

~~~
wget https://bintray.com/artifact/download/cityzendata/generic/warp10-X.Y.Z.tar.gz
tar xf warp10-X.Y.Z.tar.gz
cd warp10-X.Y.Z
~~~

## Start Warp 10 Standalone

Untar the Warp10 archive.

~~~
  tar xf warp10-X.Y.Z.tar.gz
  cd warp10-X.Y.Z/bin
~~~

Execute Warp10 init script `warp10-standalone.init`. This script must be run as **root**
It will create the Leveldb database and all the stuff surrounding it.
Then the init script starts the Standalone mode with the right user `warp10`
An initial set of tokens will be provided and some useful commands to start playing with your Warp10 instance.

~~~
  ./warp10-standalone.init start
~~~

Logs are available in the `logs` directory

Data are stored via leveldb in the `data` directory

## Data snapshot

Snapshot of leveldb data can be performed via the init script

~~~
./warp10-standalone.init snapshot 'snapshot_name'
~~~