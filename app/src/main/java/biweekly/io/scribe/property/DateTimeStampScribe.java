package biweekly.io.scribe.property;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import biweekly.ICalVersion;
import biweekly.io.SkipMeException;
import biweekly.io.WriteContext;
import biweekly.property.DateTimeStamp;

/*
 Copyright (c) 2013-2023, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Marshals {@link DateTimeStamp} properties.
 * @author Michael Angstadt
 */
public class DateTimeStampScribe extends DateTimePropertyScribe<DateTimeStamp> {
	public DateTimeStampScribe() {
		super(DateTimeStamp.class, "DTSTAMP");
	}

	@Override
	protected DateTimeStamp newInstance(Date date) {
		return new DateTimeStamp(date);
	}

	@Override
	public Set<ICalVersion> getSupportedVersions() {
		return EnumSet.of(ICalVersion.V2_0_DEPRECATED, ICalVersion.V2_0);
	}
	
	@Override
	protected String _writeText(DateTimeStamp property, WriteContext context) {
		if (context.getVersion() == ICalVersion.V1_0){
			throw new SkipMeException("This property is not used in vCal 1.0.");
		}
		return super._writeText(property, context);
	}
}
