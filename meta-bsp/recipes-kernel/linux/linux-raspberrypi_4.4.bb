FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
RDEPENDS_kernel-base += "rtl8188eu"

LINUX_VERSION ?= "4.4.28"

SRCREV = "5afda48c3408e15742d4569459a4ff668e2857f7"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.4.y \
"
require linux-raspberrypi.inc
