FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.4.50"

SRCREV = "04c8e47067d4873c584395e5cb260b4f170a99ea"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.4.y \
    file://logo.diff \
    file://logo.cfg \
    file://slcan.cfg \
    file://can-peak.cfg \
"
require linux-raspberrypi.inc
