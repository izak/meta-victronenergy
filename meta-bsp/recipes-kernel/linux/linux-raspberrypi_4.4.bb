FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.4.43"

SRCREV = "17ca1c930978a9ea6ddfec61fd0e2043e8ab3b17"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.4.y \
    file://logo.diff \
    file://logo.cfg \
    file://slcan.cfg \
    file://can-peak.cfg \
"
require linux-raspberrypi.inc
