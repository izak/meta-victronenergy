DESCRIPTION = "AVRDUDE is software for programming Atmel AVR Microcontrollers."
HOMEPAGE = "http://www.nongnu.org/avrdude/"
SECTION = "console"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "virtual/libusb0 ncurses"

SRC_URI = "http://savannah.nongnu.org/download/avrdude/avrdude-${PV}.tar.gz"

inherit autotools

