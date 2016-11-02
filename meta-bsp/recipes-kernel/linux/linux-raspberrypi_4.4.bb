FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
RDEPENDS_kernel-base += "rtl8188eu"

LINUX_VERSION ?= "4.4.23"

SRCREV = "c2a1d975537fcac01da80ce34f10bc491620a64e"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.4.y \
"
require linux-raspberrypi.inc
