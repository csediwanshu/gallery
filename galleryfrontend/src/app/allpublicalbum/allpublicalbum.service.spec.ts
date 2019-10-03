import { TestBed } from '@angular/core/testing';

import { AllpublicalbumService } from './allpublicalbum.service';

describe('AllpublicalbumService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllpublicalbumService = TestBed.get(AllpublicalbumService);
    expect(service).toBeTruthy();
  });
});
