DESCRIPTION = "dbus services which provide measurements / data on the dbus"

PR = "r5"

# To make sure all packages needed by vrmlogger, gui etc get correctly installed
# all these recipes need to RDEPEND on all services they listen too. And if another
# is added all recipes must then be altered to include the new one. By rdepending
# on this packagegroup instead there is only one location where new packages which
# provide data on the dbus need to be added.

PACKAGES = "packagegroup-ve-dbus-data-producers"
LICENSE = "MIT"

inherit packagegroup

# List of application which provide data on the dbus in a VBusItem interface.
# These are RRECOMMENDS so the are only included when available.
# vecan_mk2 is not included on purpose, since it needs MACHINE specific gpio
# lines in order to function correctly.

RRECOMMENDS_${PN} += " \
	dbus-cgwacs \
	dbus-fronius \
	dbus-motordrive \
	dbus-qwacs \
	dbus-redflow \
	dbus-systemcalc-py \
	dbus-valence \
	dbus-vebus-to-pvinverter \
	gps-dbus \
	lg-resu-interface \
	vecan-dbus \
	vedirect-interface \
"
