LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)


OpenCV_INSTALL_MODULES := on
OpenCV_CAMERA_MODULES := off

OPENCV_LIB_TYPE :=STATIC

ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
include ../../../../native/jni/OpenCV.mk
else
include $(OPENCV_MK_PATH)
endif

LOCAL_MODULE := scanner

LOCAL_SRC_FILES :=

LOCAL_LDLIBS +=  -lm -llog -ljnigraphics
LOCAL_SRC_FILES := space_bestysh_scanner_Scanner.cpp

include $(BUILD_SHARED_LIBRARY)