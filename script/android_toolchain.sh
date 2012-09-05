#!/bin/bash
if [ ! -d "/usr/gzy"]; then  
mkdir "/usr/gzy"  
fi

if [ ! -d "/usr/gzy/android-toolchain"]; then
$ANDROID_NDK_ROOT/build/tools/make-standalone-toolchain.sh --platform=android-9 --install-dir=/usr/gzy/android-toolchain
fi