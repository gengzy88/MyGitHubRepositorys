#!/bin/bash
export PATH=/usr/gzy/android-toolchain/bin:$PATH
export CC=arm-linux-androideabi-gcc
export CXX=arm-linux-androideabi-g++
export CXXFLAGS="-lstdc++"
if [ ! -d "./tmp" ]; then
	mkdir ./tmp
fi
TMPDIR="./tmp"
TEMPDIR="./tmp"
TMP="./tmp"
echo "TMPDIR="$TMPDIR
echo "TEMPDIR="$TEMPDIR
echo "TMP="$TMP
./configure --prefix=/usr/gzy/android-toolchains --disable-doc --disable-ffmpeg --disable-ffplay --disable-ffserver --disable-avfilter --disable-devices --disable-debug --disable-encoders --enable-cross-compile --enable-decoders --enable-demuxer=mov --enable-demuxer=h264 --enable-protocol=file --enable-avformat --enable-avcodec --enable-decoder=rawvideo --enable-decoder=h264 --enable-decoder=mjpeg --enable-decoder=h263 --enable-decoder=mpeg4 --enable-parser=h264 --enable-zlib --enable-shared --enable-static --enable-pic --nm=arm-linux-androideabi-nm --arch=arm --target-os=linux --cross-prefix=arm-linux-androideabi- --disable-asm
